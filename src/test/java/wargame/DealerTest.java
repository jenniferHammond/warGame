package wargame;

import org.junit.Assert;
import org.junit.Test;
import wargame.Dealer;
import wargame.Hand;

import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class DealerTest {

    @Test
    public void dealsToTwoPlayers(){
        List<Hand> hands = new Dealer().deal(2);

        Assert.assertEquals(26, hands.get(0).handSize());
        Assert.assertEquals(26, hands.get(1).handSize());
    }

    @Test
    public void dealsToThreePlayers(){
        List<Hand> hands = new Dealer().deal(3);

        Assert.assertEquals(17, hands.get(0).handSize());
        Assert.assertEquals(17, hands.get(1).handSize());
        Assert.assertEquals(17, hands.get(2).handSize());
    }

    @Test
    public void dealsToFourPlayers(){
        List<Hand> hands = new Dealer().deal(4);

        Assert.assertEquals(13, hands.get(0).handSize());
        Assert.assertEquals(13, hands.get(1).handSize());
        Assert.assertEquals(13, hands.get(2).handSize());
        Assert.assertEquals(13, hands.get(3).handSize());
    }
}
