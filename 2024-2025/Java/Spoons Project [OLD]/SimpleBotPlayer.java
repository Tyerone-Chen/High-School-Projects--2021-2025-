// SimpleBotPlayer.java
/**
 * A simple AI implementation of a Spoons player.
 * 
 * (This is a starting template. You must implement the strategy!)
 */
public class SimpleBotPlayer extends PlayerThread {
    public SimpleBotPlayer(String name) {
        super(name);
    }

    /**
     * Decides which card to pass to the right neighbor.
     * 
     * @param incoming the newly received card
     * @return the card to pass
     */
    @Override
    protected Card decideCardToPass(Card incoming) {
        // TODO: Insert the incoming card into your hand,
        // decide what to pass, and return it.
        return incoming; // Placeholder behavior
    }

    /**
     * Checks if this player has four cards of the same rank.
     * 
     * @return true if four of a kind is detected, false otherwise
     */
    @Override
    protected boolean hasFourOfAKind() {
        // TODO: Implement logic to check if four cards have the same rank.
        return false; // Placeholder behavior
    }
    
    public String toString(){
      return "[INTENTIONALLY] " + super.toString();
    }
}
