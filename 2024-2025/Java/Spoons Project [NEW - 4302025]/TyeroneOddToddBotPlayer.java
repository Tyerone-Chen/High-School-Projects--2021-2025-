// TyeroneOddToddBotPlayer.java
/*
   Author: Tyerone Chen
   Create Date: 4/1/2025
   Last Update: 5/1/2025
*/

/**
 * A simple AI implementation of a Spoons player.
 * This one is just biased to a only keep odd rank cards
 * Will pass every card that ISN'T the an odd rank.
 */
 
 // Imported Libraries
 import java.util.Random;


public class TyeroneOddToddBotPlayer implements SpoonsStrategy {
  // Sub-Class Specific Variables
  private final Card[] hand = new Card[4];
  private Card overflow_card = null; // Used to hold a card when the hand is full of cards already
  private String[] odd_ranks = {
    "A",
    "3",
    "5",
    "7",
    "9"
  };
  private final String name;

  public TyeroneOddToddBotPlayer(String name) {
    this.name = name;
  }

  @Override
  public void receiveCard(Card incoming) {
    // Check if the hand is full to bypass the for loop section
    if (getHandSize() == 4) {
      overflow_card = incoming;
      return;
    }

    // Loop through the hand to find an empty slot and fill it with the incoming card
    for (int i = 0; i < hand.length; i++) {
      if (hand[i] == null) { // Check to see if it is a empty slot
        hand[i] = incoming;
        return;
      }
    }
  }

  @Override
  public Card decideCardToPass() {
    // When there is nothing in the overflow card slot, pass nothing
    if (overflow_card == null) return null;
    
    Card card_to_pass;

    // When there is an overflow_card check through each card in hand to see if it is odd rank
    for (int i = 0; i < 4; i++) {
      if (hand[i] == null) continue; // Pass over null cards in hand
      boolean is_odd = false;
      
      for (String rank: odd_ranks) { // Iterate over each odd rank
        if (hand[i].getRank().equals(rank)) {
           is_odd = true;
           break;      
        } 
      }
      
      if (!is_odd) { // If the card in hand isnt odd pass it
         card_to_pass = hand[i];
         hand[i] = overflow_card;
         overflow_card = null;
         return card_to_pass;
       }
    }
    
    // In the case of a full hand of odds randomly choose a card in hand and discard that    
    Random random = new Random();
    int rand_index = random.nextInt(4);
    card_to_pass = hand[rand_index]; // I could make it into a function buttttttt idc
    hand[rand_index] = overflow_card;
    overflow_card = null;
    return card_to_pass;
  }

  @Override
  public boolean hasFourOfAKind() {
    int[] rank_counts = new int[odd_ranks.length]; // Create a parallel array to odd_ranks
    // Checks if the current hand has a four of a kind of the fav_rank
    for (Card card: hand) {
        if (card == null) continue; // Pass over any null hand cards
        for (int i = 0; i< odd_ranks.length; i++){
            if (card.getRank().equals(odd_ranks[i])) { // Checks if any card in hand is in odd_ranks
               rank_counts[i]++; // Increases the count for that respective card
               break;
            } 
        } 
    }

    for (int count : rank_counts) {
      if (count == 4) { // Counts up each rank count
         return true;
      }
    }
    
    return false;
  }

  @Override
  public int getHandSize() {
    int size = 0;
    for (Card card: hand) { // Counts each card in hand that isn't null, which should count the hand size
      if (card != null) {
        size++;
      }
    }
    return size;
  }

  @Override
  public String getStrategyName() {
    return "BiasedBot";
  }

  @Override
  public String toString() {
    String return_msg = name + "'s hand: [ ";
    for (Card card: hand) {
      return_msg = return_msg + card + ", ";
    }
    return_msg += "]";
    return return_msg;
  }
}