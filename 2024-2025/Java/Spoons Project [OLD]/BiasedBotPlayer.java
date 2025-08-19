// BiasedBotPlayer.java
/*
   Author: Tyerone Chen
   Create Date: 4/29/2025
   Last Update: 4/29/2025
*/

/**
 * A simple AI implementation of a Spoons player.
 * This one is just biased to a fav_rank that it wants to choose at the beggining of the game
 * Will pass every card that ISNT the fav_rank
 */
// Libraries
import java.util.Random; 
 
public class BiasedBotPlayer extends PlayerThread {
    // Sub-Class Specific Variables
    protected String fav_rank;
    protected boolean is_hand_full = false;

    public BiasedBotPlayer(String name) {
        super(name);
        // Generate a random rank that this player will want to keep
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Random random = new Random();
        this.fav_rank = ranks[random.nextInt(ranks.length)];
    }

    /**
     * Decides which card to pass to the right neighbor.
     * 
     * @param incoming the newly received card
     * @return the card to pass
     */
    @Override
    protected Card decideCardToPass(Card incoming) {
        // When player hand isnt full, draw the card to hand and dont pass anything
        for (int i = 0; i < 4; i++) {
            if (hand[i] == null) {
               hand[i] = incoming;
               return null;
            }
        }
        
        // When hand is full, check if incoming is fav rank, if so then find a card that isnt a fav rank and replace and discard the non-fav-card
        if (incoming.getRank().equals(fav_rank)) {
           for (int i = 0; i < 4; i++) {
               if (!hand[i].getRank().equals(fav_rank)) {
                  Card card_to_pass = hand[i];
                  hand[i] = incoming;
                  return card_to_pass;
               }
           }
        }
        
        return incoming;
    }

    /**
     * Checks if this player has four cards of the same rank.
     * 
     * @return true if four of a kind is detected, false otherwise
     */
    @Override
    protected boolean hasFourOfAKind() {
        int counter = 0;
        // Checks if the current hand has a four of a kind of the fav_rank
        for (Card card : hand) {
            if (card != null && card.getRank().equals(fav_rank)) {
               counter++;
            } 
        }
        
        return counter == 4;
    }
    
    public String toString(){
      return "[INTENTIONALLY] " + super.toString();
    }
}
