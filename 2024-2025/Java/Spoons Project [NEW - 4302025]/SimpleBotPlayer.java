import java.util.ArrayList;
import java.util.List;

/**
 * SimpleBotPlayer
 * 
 * A minimal, beginner-friendly implementation of the {@code SpoonsStrategy} interface.
 * <p>
 * This strategy does not make smart decisions. It always accepts incoming cards
 * and, once the hand is full, discards the first card in its hand. It does not attempt
 * to build four-of-a-kind and always returns {@code false} for win detection.
 * </p>
 * 
 * <p>
 * Intended as a starting point for student modification. Students must implement
 * meaningful strategy logic in {@code decideCardToPass()} and {@code hasFourOfAKind()}.
 * </p>
 */
public class SimpleBotPlayer implements SpoonsStrategy {

  private final List < Card > hand = new ArrayList < > ();
  private final String name;

  /**
   * Constructs a SimpleBotPlayer with the given name.
   *
   * @param name a label used in logging and display
   */
  public SimpleBotPlayer(String name) {
    this.name = name;
  }

  /**
   * Adds an incoming card to the bot’s internal hand.
   * <p>
   * This implementation does not enforce a hand limit or safety checks,
   * so it must be paired with a discard in the same turn if already holding 4 cards.
   * </p>
   *
   * @param incoming the card passed from the left neighbor
   */
  @Override
  public void receiveCard(Card incoming) {
    hand.add(incoming);
  }

  /**
   * Chooses a card to pass to the right neighbor.
   * <p>
   * Once the hand contains 4 cards, the bot simply passes the first card it holds.
   * </p>
   * 
   * @return the card to pass, or {@code null} if the hand is not yet full
   */
  @Override
  public Card decideCardToPass() {
    if (hand.size() <= 4) return null;

    // Very basic discard policy: pass the first card
    return hand.remove(0);
  }

  /**
   * Always returns false.
   * <p>
   * This implementation does not attempt to check for four of a kind.
   * Students should override this method with real win-check logic.
   * </p>
   * 
   * @return false, indicating this bot never wins
   */
  @Override
  public boolean hasFourOfAKind() {
    return false;
  }

  /**
   * Returns the human-readable name of this strategy.
   *
   * @return "SimpleBot"
   */
  @Override
  public String getStrategyName() {
    return "SimpleBot";
  }

  /**
   * Returns the number of cards currently held in hand.
   * 
   * @return the hand size (usually between 0 and 4)
   */
  @Override
  public int getHandSize() {
    return hand.size();
  }

  /**
   * Returns a visual representation of the current hand and bot name.
   * Used in logging and debugging.
   *
   * @return a string like "BotName's hand: [3 of Hearts, 5 of Spades, ...]"
   */
  @Override
  public String toString() {
    String return_msg = name + "'s hand: ";
    return return_msg;
  }
}