/**
 * Represents a standard playing card characterized by a rank and a suit.
 * <p>
 * Instances of this class are immutable and can be used reliably in collections
 * that depend on consistent implementations of {@code equals()} and {@code hashCode()},
 * such as {@link java.util.HashSet} or {@link java.util.HashMap}.
 * </p>
 */
public class Card {
    private final String rank;
    private final String suit;

    /**
     * Constructs a {@code Card} with the specified rank and suit.
     *
     * @param rank the rank of the card (e.g., "Ace", "2", ..., "King")
     * @param suit the suit of the card (e.g., "Hearts", "Spades")
     */
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of this card.
     *
     * @return the rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns the suit of this card.
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of this card in the format "Rank-Suit".
     * <p>
     * For example, "Queen-Hearts" or "10-Clubs".
     * </p>
     *
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return rank + "-" + suit;
    }

    /**
     * Compares this card to the specified object for equality.
     * <p>
     * Two cards are considered equal if they have the same rank and suit.
     * </p>
     *
     * @param obj the object to compare with
     * @return {@code true} if the specified object is equal to this card; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return rank.equals(other.rank) && suit.equals(other.suit);
    }
    
    /**
    * Creates a Card from a short string code, e.g. "Q-H" or "10-D".
    * 
    * @param code the string format "RANK-SUIT" where RANK is one of A, 2–10, J, Q, K
    *             and SUIT is one of H (Hearts), D (Diamonds), C (Clubs), S (Spades)
    * @return a new Card object representing the given code
    * @throws IllegalArgumentException if the input format is invalid
    */
   public static Card fromCode(String code) {
       if (code == null || !code.matches("^(A|[2-9]|10|J|Q|K)-[HDCS]$")) {
           throw new IllegalArgumentException("Invalid card code: " + code);
       }
   
       String[] parts = code.split("-");
       return new Card(parts[0], parts[1]);
   }


    /**
     * Returns a hash code value for this card.
     * <p>
     * The hash code is computed based on the rank and suit, ensuring that equal cards
     * have the same hash code, which is essential for the correct operation of hash-based collections.
     * </p>
     *
     * @return a hash code value for this card
     */
    @Override
    public int hashCode() {
        return 31 * rank.hashCode() + suit.hashCode();
    }
}
