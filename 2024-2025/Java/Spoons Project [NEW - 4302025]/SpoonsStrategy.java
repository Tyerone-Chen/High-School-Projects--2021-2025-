/**
 * SpoonsStrategy
 * 
 * An interface for defining autonomous player behavior in the Spoons card game simulation.
 * Each strategy is responsible for maintaining its own hand, determining which card to pass,
 * and checking whether it has achieved four of a kind.
 * 
 * Implementations may use different internal data structures (ArrayList, Set, Map, etc.)
 * and logic to pursue a win condition. Strategies are interchangeable using the Strategy Pattern.
 */
public interface SpoonsStrategy {

    /**
     * Receives a new card from the left-hand neighbor.
     * The strategy is responsible for inserting this card into its internal hand.
     * 
     * @param incoming the Card object passed from the left neighbor
     * @pre incoming is not null
     * @post internal hand may increase in size or may discard an existing card to maintain size limit
     */
    void receiveCard(Card incoming);

    /**
     * Determines which card, if any, should be passed to the right neighbor.
     * If the hand is not full, this method should return null, indicating no card will be passed this turn.
     * 
     * @return the Card to be passed to the right, or null if no card is passed
     * @pre strategy has already received a card this turn
     * @post if a card is returned, it must have been removed from the internal hand
     */
    Card decideCardToPass();

    /**
     * Checks whether the current internal hand contains four cards of the same rank.
     * This triggers the spoon race in the simulation.
     * 
     * @return true if the hand contains four cards of the same rank, false otherwise
     * @pre hand must contain up to four cards
     * @post returns a boolean representing win condition
     */
    boolean hasFourOfAKind();

    /**
     * Returns the current number of cards in the strategy’s internal hand.
     * 
     * @return the number of cards currently held by the strategy (typically between 0 and 4)
     */
    int getHandSize();

    /**
     * Returns the human-readable name of the strategy.
     * Used for logging, scoring, and display purposes.
     * 
     * @return a short descriptive name for this strategy (e.g., "RandomBot", "MemoryBot")
     */
    String getStrategyName();

    /**
     * Returns a human-readable representation of the strategy’s current state,
     * typically including the contents of its hand or other internal data.
     * 
     * @return a string describing the strategy's current state
     */
    @Override
    String toString();
}
