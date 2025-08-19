// SpoonsTable.java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Sets up and runs a simulation of the Spoons card game with status output.
 */
public class SpoonsTable {
    private final List<PlayerThread> players = new ArrayList<>();
    private final Deck deck = new Deck();
    private final BlockingDeque<Utensil> spoonStack = new LinkedBlockingDeque<>();
    private final AtomicBoolean spoonRaceStarted = new AtomicBoolean(false);
    private final int numSpoons;

    /**
     * Constructs a new SpoonsTable with a provided list of players.
     * @param playerList the list of PlayerThread objects participating
     */
    public SpoonsTable(List<PlayerThread> playerList) {
        players.addAll(playerList);
        this.numSpoons = players.size() - 1; // One fewer spoon than players
        linkQueues();
        setupSpoons(players.size());
    }

    /**
     * Connects players in a circular queue setup.
     */
    private void linkQueues() {
        int n = players.size();
        List<BlockingQueue<Card>> queues = new ArrayList<>();

        // Create one queue per player
        for (int i = 0; i < n; i++) {
            queues.add(new ArrayBlockingQueue<>(52)); // Large enough to hold multiple cards
        }

        // Assign each player their left (input) and right (output) queues
        for (int i = 0; i < n; i++) {
            PlayerThread current = players.get(i);
            BlockingQueue<Card> left = queues.get(i);
            BlockingQueue<Card> right = queues.get((i + 1) % n);
            current.setQueues(left, right);
        }
    }

    /**
     * Fills the utensil stack with spoons and one hidden fork.
     */
    private void setupSpoons(int numPlayers) {
        // Add all but one utensil as spoons
        for (int i = 0; i < numPlayers - 1; i++) {
            spoonStack.addLast(new Utensil("Spoon"));
        }
        spoonStack.addLast(new Utensil("Fork")); // One player gets forked!

        System.out.println("[Setup] Utensil Stack Initialized: " + (numPlayers - 1) + " Spoons + 1 Fork");

        // Share the spoon stack and trigger with each player
        for (PlayerThread player : players) {
            player.setSpoonStack(spoonStack);
            player.setSpoonRaceTrigger(spoonRaceStarted);
        }
    }

    /**
     * Distributes the entire deck across all player queues and starts the game.
     */
    public void startGame() {
        int numPlayers = players.size();
        int index = 0;

        System.out.println("[Setup] Shuffling and distributing the deck...");
        
        // Distribute entire shuffled deck evenly to each player's leftQueue
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

        // Show each player’s queue size before starting
        for (PlayerThread player : players) {
            System.out.println(player.getName() + " starting hand size (queued): " + player.leftQueue.size());
        }

        System.out.println("[Game Start] Players ready. Starting simulation...\n");

        // Start all player threads
        for (PlayerThread player : players) {
            player.start();
        }
    }
}
