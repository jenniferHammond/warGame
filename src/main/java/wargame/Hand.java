package wargame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class Hand {

    private LinkedList<Card> cards;

    public Hand(){
        cards = new LinkedList<Card>();
    }

    public boolean hasCards(){
        return cards.size() > 0;
    }

    public Card playCard(){
        return cards.removeFirst();
    }

    public void addCardsToHand(Collection<Card> cards){
        cards.addAll(cards);
    }

    public void addCardToHand(Card card){
        cards.add(card);
    }

    /*
     * Useful for tests, but this shouldn't be used by the game itself.
     * Are you out of cards, or aren't you?
     */
    int handSize() {
        return cards.size();
    }
}
