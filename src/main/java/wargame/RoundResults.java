package wargame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class RoundResults {

    private List<Player> winners;
    private final List<Card> cardsWon;

    public RoundResults(){
        cardsWon = new ArrayList<Card>();
        winners = new ArrayList<Player>();
    }

    public boolean isDraw(){
        return winners.size() > 1;
    }

    public void addCardsWon(List<Card> cards){
        cardsWon.addAll(cards);
    }

    public void addCardWon(Card card){
        cardsWon.add(card);
    }

    public List<Card> getCardsWon() {
        return cardsWon;
    }

    public void addWinner(Player player){
        winners.add(player);
    }

    public List<Player> getWinners() {
        return winners;
    }
}
