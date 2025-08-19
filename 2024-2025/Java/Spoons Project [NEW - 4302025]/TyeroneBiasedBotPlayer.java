// TyeroneBiasedBotPlayer.java
/*
   Author: Tyerone Chen
   Create Date: 4/29/2025
   Last Update: 5/1/2025
*/

/**
 * A simple AI implementation of a Spoons player.
 * This one is just biased to a fav_rank that it wants to choose at the beginning of the game.
 * Will pass every card that ISN'T the fav_rank.
 */
 
// Imported Libraries
import java.util.Random;

public class TyeroneBiasedBotPlayer implements SpoonsStrategy {
  // Sub-Class Specific Variables
  private final Card[] hand = new Card[4];
  private Card overflow_card = null; // Used to hold a card when the hand is full of cards already
  private String fav_rank; // Main logic variable used <- its just a random rank lol
  private final String name;

  public TyeroneBiasedBotPlayer(String name) {
    this.name = name;
    // Generate a random rank that this player will want to keep
    String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    Random random = new Random();
    this.fav_rank = ranks[random.nextInt(ranks.length)];
    //this.fav_rank = "4"; // Overider for testing - Remove Later
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

    // When hand is full, check if incoming is fav rank, 
    // if so then find a card that isn't a fav rank and replace and discard the non-fav-card
    for (int i = 0; i < 4; i++) {
      if (hand[i] != null && !hand[i].getRank().equals(fav_rank)) {
        card_to_pass = hand[i];
        hand[i] = overflow_card;
        overflow_card = null;
        return card_to_pass;
      }
    }
    card_to_pass = overflow_card;
    overflow_card = null;
    return card_to_pass;
  }

  @Override
  public boolean hasFourOfAKind() {
    int counter = 0;
    // Checks if the current hand has a four of a kind of the fav_rank
    for (Card card: hand) {
      if (card != null && card.getRank().equals(fav_rank)) {
        counter++;
      }
    }

    return counter == 4;
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