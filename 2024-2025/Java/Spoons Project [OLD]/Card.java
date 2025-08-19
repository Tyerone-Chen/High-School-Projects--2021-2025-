// Card.java
/**
 * Represents a standard playing card with a rank and suit.
 */
public class Card {
    private final String rank;
    private final String suit;

    /**
     * Constructs a card with a given rank and suit.
     */
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + "-" + suit;
    }

   @Override
   public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;
       Card other = (Card) obj;
       return rank.equals(other.rank) && suit.equals(other.suit);
   }

   @Override
   public int hashCode() {
       return 31 * rank.hashCode() + suit.hashCode();
   }
}