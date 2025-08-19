// PlayerThread.java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Arrays;

/**
 * Abstract class representing a player in the Spoons game.
 * Each player operates in their own thread.
 */
public abstract class PlayerThread extends Thread {
    protected final String name;
    protected final Card[] hand = new Card[4]; // Fixed-size hand
    protected BlockingQueue<Card> leftQueue;   // Queue receiving from left neighbor
    protected BlockingQueue<Card> rightQueue;  // Queue passing to right neighbor
    protected BlockingDeque<Utensil> spoonStack; // Shared utensil stack
    protected AtomicBoolean spoonRaceStarted;  // Shared race trigger
    protected volatile boolean gameRunning = true;

    private static final int TIMEOUT_MS = 200;  // Timeout for queue operations
    private static final int SLEEP_TIME_MS = 5; // Thinking delay per loop

    public PlayerThread(String name) {
        super(name);
        this.name = name;
    }

    /**
     * Assigns this player their left and right queues.
     */
    public void setQueues(BlockingQueue<Card> left, BlockingQueue<Card> right) {
        this.leftQueue = left;
        this.rightQueue = right;
    }

    /**
     * Sets the shared spoon stack for the game.
     */
    public void setSpoonStack(BlockingDeque<Utensil> stack) {
        this.spoonStack = stack;
    }

    /**
     * Sets the shared race trigger used to indicate the spoon race has begun.
     */
    public void setSpoonRaceTrigger(AtomicBoolean trigger) {
        this.spoonRaceStarted = trigger;
    }

    /**
     * Gets a card from the left neighbor, with timeout.
     */
    public Card getCardLeft() throws InterruptedException {
        return leftQueue.poll(TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    /**
     * Passes a card to the right neighbor, with timeout.
     */
    public void offerCardRight(Card card) throws InterruptedException {
        if (!rightQueue.offer(card, TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
            System.err.println(name + " failed to pass card — timed out.");
        } else {
            System.out.println(name + " passed card: " + card + "\t\t\t" +this.toString());
        }
    }

    /**
     * Checks if the player currently holds four cards of the same rank.
     * 
     * @return true if four of a kind is detected; false otherwise
     */
    protected abstract boolean hasFourOfAKind();

    /**
     * Triggers the spoon grabbing behavior when a player detects a win condition.
     */
    protected void attemptToGrabSpoon() {
        Utensil utensil = spoonStack.pollFirst(); // simulate 'pop'

        if (utensil == null) {
            System.out.println(name + " was too slow — no spoon left!");
        } else if (utensil.isFork()) {
            System.out.println(name + " grabbed the FORK!");
        } else {
            System.out.println(name + " grabbed a spoon!");
        }

        gameRunning = false;
    }

    @Override
    public void run() {
        try {
            while (gameRunning) {
                // If someone already triggered the spoon race, try to grab a spoon immediately
                if (spoonRaceStarted.get()) {
                    System.out.println(name + " sees the spoon race has started!");
                    attemptToGrabSpoon();
                    break;
                }

                Card incoming = getCardLeft();
                if (incoming == null) continue; // Skip turn if no card received in time

                System.out.println(name + " received card: " + incoming + "\t\t" +this.toString());

                Card discard = decideCardToPass(incoming);  // Decide what to pass using incoming card
                
                // Only pass a card to the right if we actually have something to pass
               if (discard != null) {
                   offerCardRight(discard);
                  //System.out.println(name + " passed card: " + discard);
               } else {
                  //System.out.println(name + " kept the card, no pass.");
               }

                if (hasFourOfAKind()) {
                    
                    if (spoonRaceStarted.compareAndSet(false, true)) {
                        System.out.println(name + " triggered the spoon race! 🏃‍♂️🏃‍♀️");
                    }
                    
                    attemptToGrabSpoon();                   // Try to win
                    
                    break;
                }

                Thread.sleep(SLEEP_TIME_MS); // Sleep now uses the constant
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Determines which card from the hand should be passed to the right,
     * incorporating the newly received card.
     *
     * @param incoming the newly received card from the left
     * @return the selected card to discard
     */
    protected abstract Card decideCardToPass(Card incoming);
    
    public String toString(){
      return "[[" + leftQueue.size() + "]] >> " + Arrays.toString(hand) + " >> [[" + rightQueue.size() + "]]";
    }
}
