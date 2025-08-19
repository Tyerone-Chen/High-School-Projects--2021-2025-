// Deck.java
import java.util.Collections;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a shuffled stack of cards.
 */
public class Deck {
    private Stack<Card> cards = new Stack<>();

    /**
     * Initializes a standard 52-card deck and shuffles it.
     */
    public Deck() {
        //String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
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
     * Deals one card from the top of the stack.
     */
    public Card dealOne() {
        return cards.isEmpty() ? null : cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
