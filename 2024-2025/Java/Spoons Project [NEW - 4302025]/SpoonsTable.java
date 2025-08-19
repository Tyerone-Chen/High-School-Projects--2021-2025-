import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Sets up and runs a simulation of the Spoons card game with player threads and utensil race.
 * <p>
 * Handles the initialization of players, card distribution, queue linking,
 * and spoon/fork setup. Coordinates the start of the game by launching all players
 * into concurrent play.
 * </p>
 */
public class SpoonsTable {
    private final List<PlayerThread> players = new ArrayList<>();
    private final Deck deck = new Deck();
    private final BlockingDeque<Utensil> spoonStack = new LinkedBlockingDeque<>();
    private final AtomicBoolean spoonRaceStarted = new AtomicBoolean(false);
    private final int numSpoons;

    /**
     * Constructs a new {@code SpoonsTable} with a given list of players.
     *
     * @param playerList the list of {@code PlayerThread} objects participating in the game
     */
    public SpoonsTable(List<PlayerThread> playerList) {
        players.addAll(playerList);
        this.numSpoons = players.size() - 1; // One fewer spoon than players
        linkQueues();
        setupSpoons(players.size());
    }

    /**
     * Starts the Spoons game.
     * <p>
     * Distributes the deck evenly across all player queues and launches all player threads.
     * </p>
     */
    public void startGame() {
        int numPlayers = players.size();
        int index = 0;

        System.out.println("[Setup] Shuffling and distributing the deck...");

        // Distribute entire shuffled deck across players
        while (!deck.isEmpty()) {
            PlayerThread player = players.get(index % numPlayers);
            try {
                Card dealt = deck.dealOne();
                player.leftQueue.put(dealt);
                System.out.println(player.getName() + " receives card: " + dealt);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Failed to deal to " + player.getName());
            }
            index++;
        }

        System.out.println("[Setup] Deck fully distributed. Each player has cards queued to start.");

        // Display each player's initial hand size (queued cards)
        for (PlayerThread player : players) {
            System.out.println(player.getName() + " starting hand size (queued): " + player.leftQueue.size());
        }

        System.out.println("[Game Start] Players ready. Starting simulation...\n");

        // Start each player thread
        for (PlayerThread player : players) {
            player.start();
        }
    }

    /**
     * Links players together in a circular fashion by assigning their left and right queues.
     */
    private void linkQueues() {
        int n = players.size();
        List<BlockingQueue<Card>> queues = new ArrayList<>();

        // Create a queue for each player
        for (int i = 0; i < n; i++) {
            queues.add(new ArrayBlockingQueue<>(52)); // Large enough to hold multiple cards
        }

        // Set each player's left and right queues
        for (int i = 0; i < n; i++) {
            PlayerThread current = players.get(i);
            BlockingQueue<Card> left = queues.get(i);
            BlockingQueue<Card> right = queues.get((i + 1) % n);
            current.setQueues(left, right);
        }
    }

    /**
     * Sets up the shared utensil stack with the correct number of spoons and one fork.
     *
     * @param numPlayers the total number of players participating
     */
    private void setupSpoons(int numPlayers) {
        // Add spoons (one fewer than number of players)
        for (int i = 0; i < numPlayers - 1; i++) {
            spoonStack.addLast(new Utensil("Spoon"));
        }
        // Add the single fork
        spoonStack.addLast(new Utensil("Fork"));

        System.out.println("[Setup] Utensil Stack Initialized: " + (numPlayers - 1) + " Spoons + 1 Fork");

        // Give each player access to the utensil stack and race trigger
        for (PlayerThread player : players) {
            player.setSpoonStack(spoonStack);
            player.setSpoonRaceTrigger(spoonRaceStarted);
        }
    }
}
