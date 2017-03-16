package wargame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class Player {

    private final int playerNumber;
    private LinkedList<Card> cards;

    public Player(int playerNumber){
        this.playerNumber = playerNumber;
        cards = new LinkedList<Card>();
    }

    public boolean hasCards(){
        return cards.size() > 0;
    }

    public Card playCard(){
        return cards.removeFirst();
    }

    public void addCardsToHand(Collection<Card> newCards){
        cards.addAll(newCards);
    }

    public void addCardToHand(Card card){
        cards.add(card);
    }

    @Override
    public String toString() {
        return "Player" + playerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return playerNumber == player.playerNumber;
    }

    @Override
    public int hashCode() {
        return playerNumber;
    }

    /*
     * Useful for tests, but this shouldn't be used by the game itself.
     * Are you out of cards, or aren't you?
     */
    int handSize() {
        return cards.size();
    }
}
