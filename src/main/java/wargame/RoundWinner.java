package wargame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class RoundWinner {

    private Player winner;
    private final List<Card> cardsWon;

    public RoundWinner(){
        cardsWon = new ArrayList<Card>();
        winner = new Player(0);
    }

    public void addCardsWon(List<Card> cards){
        cardsWon.addAll(cards);
    }

    public List<Card> getCardsWon() {
        return cardsWon;
    }

    public void setWinner(Player player){
        this.winner = player;
    }

    public Player getWinner() {
        return winner;
    }
}
