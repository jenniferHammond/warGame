package wargame;

/**
 * Created by Jen on 3/15/2017.
 */
public class Play implements Comparable{

    private final Player player;
    private final Card card;

    public Play(Player player, Card card){

        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    public int compareTo(Object play) {
        Integer thisValue = this.card.getValue();
        Integer thatValue = ((wargame.Play)play).card.getValue();

        return thisValue.compareTo(thatValue);
    }

    @Override
    public String toString() {
        return player + ": " + card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        wargame.Play play = (wargame.Play) o;

        return card != null ? card.equals(play.card) : play.card == null;
    }

    @Override
    public int hashCode() {
        return card != null ? card.hashCode() : 0;
    }
}