import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * PlayerThread
 * 
 * A threaded player agent in the Spoons simulation. Each player continuously:
 * - receives cards from the left neighbor via a blocking queue,
 * - delegates decision logic to a SpoonsStrategy object,
 * - passes cards to the right neighbor,
 * - checks for a win condition (four of a kind),
 * - and races to grab a spoon or fork from the shared utensil stack.
 *
 * This class models asynchronous game logic and uses composition to offload
 * decision-making to pluggable strategy objects.
 */
public class PlayerThread extends Thread {
    protected final String name;                  // The name of the player
    protected final SpoonsStrategy strategy;      // The player's behavior module (Strategy Pattern)

    protected BlockingQueue<Card> leftQueue;      // Incoming cards from the left neighbor
    protected BlockingQueue<Card> rightQueue;     // Outgoing cards to the right neighbor
    protected BlockingDeque<Utensil> spoonStack;  // Shared utensil stack (spoons + fork)
    protected AtomicBoolean spoonRaceStarted;     // Shared race trigger between all players
    protected volatile boolean gameRunning = true; // Flag to control the main loop

    private static final int TIMEOUT_MS = 200;     // Timeout for blocking queue operations
    private static final int SLEEP_TIME_MS = 5;    // Simulated thinking delay

    /**
     * Constructs a PlayerThread using a specified name and strategy.
     * 
     * @param name the label for the player thread
     * @param strategy the behavior logic implementation
     */
    public PlayerThread(String name, SpoonsStrategy strategy) {
        super(name);
        this.name = name;
        this.strategy = strategy;
    }

    /**
     * Assigns the input/output queues for card passing.
     * 
     * @param left  the incoming card queue from the left neighbor
     * @param right the outgoing card queue to the right neighbor
     */
    public void setQueues(BlockingQueue<Card> left, BlockingQueue<Card> right) {
        this.leftQueue = left;
        this.rightQueue = right;
    }

    /**
     * Assigns the shared utensil stack for spoon grabbing.
     * 
     * @param stack a shared deque of spoons and one fork
     */
    public void setSpoonStack(BlockingDeque<Utensil> stack) {
        this.spoonStack = stack;
    }

    /**
     * Assigns the shared spoon race trigger flag.
     * 
     * @param trigger the shared AtomicBoolean coordinating spoon grabbing
     */
    public void setSpoonRaceTrigger(AtomicBoolean trigger) {
        this.spoonRaceStarted = trigger;
    }

    /**
     * Attempts to retrieve a card from the left-hand neighbor.
     * Times out after {@code TIMEOUT_MS} if no card is available.
     * 
     * @return the received Card, or null if none received
     * @throws InterruptedException if thread is interrupted during wait
     */
    public Card getCardLeft() throws InterruptedException {
        return leftQueue.poll(TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    /**
     * Attempts to pass a card to the right-hand neighbor.
     * 
     * @param card the Card to pass
     * @throws InterruptedException if thread is interrupted while waiting
     */
    public void offerCardRight(Card card) throws InterruptedException {
        if (!rightQueue.offer(card, TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
            System.err.println(name + " failed to pass card — timed out.");
        } else {
            System.out.println(name + " passed card: " + card + "\t\t\t" + this.toString());
        }
    }

    /**
     * Returns a snapshot of this player's state including:
     * - the left queue size,
     * - current hand (via strategy.toString()),
     * - and right queue size.
     */
    @Override
    public String toString() {
        return "[[" + leftQueue.size() + "]] >> " + strategy.toString() + " >> [[" + rightQueue.size() + "]]";
    }

    /**
     * The player's main loop:
     * - Listens for incoming cards
     * - Updates the internal strategy
     * - Determines a discard
     * - Checks for four of a kind
     * - Responds to a triggered spoon race
     */
    @Override
    public void run() {
        try {
            while (gameRunning) {
                // Stop immediately if race is already in progress
                if (spoonRaceStarted.get()) {
                    System.out.println(name + " sees the spoon race has started!");
                    attemptToGrabSpoon();
                    break;
                }

                Card incoming = getCardLeft();
                if (incoming == null) continue;

                System.out.println(name + " received card: " + incoming + "\t\t" + this.toString());

                strategy.receiveCard(incoming);
                Card discard = strategy.decideCardToPass();

                if (discard != null) {
                    offerCardRight(discard);
                }

                if (strategy.hasFourOfAKind()) {
                    if (spoonRaceStarted.compareAndSet(false, true)) {
                        System.out.println(name + " triggered the spoon race! 🏃‍♂️🏃‍♀️");
                    }
                    attemptToGrabSpoon();
                    break;
                }

                Thread.sleep(SLEEP_TIME_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Respect thread interruption
        }
    }

    /**
     * Attempts to grab a spoon (or fork) from the shared stack.
     * Updates game state and announces result.
     */
    protected void attemptToGrabSpoon() {
        Utensil utensil = spoonStack.pollFirst();

        if (utensil == null) {
            System.out.println(name + " was too slow — no spoon left!");
        } else if (utensil.isFork()) {
            System.out.println(name + " grabbed the FORK!");
        } else {
            System.out.println(name + " grabbed a spoon!");
        }

        gameRunning = false;
    }
}
