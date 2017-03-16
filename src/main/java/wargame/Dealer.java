package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class Dealer {
     /*
     * return a given number of hands from a new deck.
     */
    public List<Hand> deal(int numPlayers){
        List<Card> deck = newDeck();

        int cardsPerPlayer = cardsPerPlayer(numPlayers);
        
        List<Hand> hands = new ArrayList<Hand>(cardsPerPlayer);
        for(int i=0; i<numPlayers; i++){
            hands.add(new Hand());
        }
        
        for(int i = 0; i<cardsPerPlayer; i++){
            for (Hand hand : hands) {
                hand.addCardToHand(deck.remove(0));
            }
        }

        return hands;
    }

    /*
     * Generate a new, shuffled deck of cards.
     */
    private List<Card> newDeck(){
        List<Card> deck = new ArrayList<Card>(52);

        // add regular cards
        for (int cardValue = 2; cardValue<11; cardValue++){
            for(int suits = 0; suits<4; suits++){
                deck.add(new Card(cardValue, Integer.toString(cardValue)));
            }
        }

        // add face cards
        for(int suits = 0; suits<4; suits++){
            deck.add(new Card(11, "J"));
            deck.add(new Card(12, "Q"));
            deck.add(new Card(13, "K"));
            deck.add(new Card(14, "A"));
        }

        // don't forget to shuffle!
        Collections.shuffle(deck);

        return deck;
    }

    private int cardsPerPlayer(int numPlayers){
        if(numPlayers == 2){
            return 26;
        }
        else if(numPlayers == 3){
            return 17;
        }
        else if(numPlayers == 4){
            return 13;
        }
        throw new IllegalArgumentException("Cannot deal for " + numPlayers + " players");
    }
}
