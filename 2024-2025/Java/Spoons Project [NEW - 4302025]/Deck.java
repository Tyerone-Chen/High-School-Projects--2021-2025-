import java.util.Collections;
import java.util.Stack;

/**
 * Represents a standard 52-card deck that can be shuffled and dealt from.
 * <p>
 * The deck is internally managed as a {@link java.util.Stack} of {@link Card} objects,
 * allowing efficient dealing from the "top" of the stack.
 * </p>
 */
public class Deck {
    private Stack<Card> cards = new Stack<>();

    /**
     * Constructs a new {@code Deck} containing 52 standard playing cards
     * (Ace through King in four suits) and shuffles them.
     * <p>
     * Suits are abbreviated as "H" (Hearts), "D" (Diamonds), "C" (Clubs), and "S" (Spades).
     * Ranks are represented as "A", "2"-"10", "J", "Q", "K".
     * </p>
     */
    public Deck() {
        String[] suits = {"H", "D", "C", "S"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.push(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards); // Shuffle the deck after creation
    }

    /**
     * Deals (removes and returns) one card from the top of the deck.
     *
     * @return the top {@code Card}, or {@code null} if the deck is empty
     */
    public Card dealOne() {
        return cards.isEmpty() ? null : cards.pop();
    }

    /**
     * Checks whether the deck is empty.
     *
     * @return {@code true} if no cards remain in the deck; {@code false} otherwise
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
