package wargame;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class DealerTest {

    @Test
    public void dealsToTwoPlayers(){
        List<Player> players = new Dealer().deal(2);

        Assert.assertEquals(26, players.get(0).handSize());
        Assert.assertEquals(26, players.get(1).handSize());
    }

    @Test
    public void dealsToThreePlayers(){
        List<Player> players = new Dealer().deal(3);

        Assert.assertEquals(17, players.get(0).handSize());
        Assert.assertEquals(17, players.get(1).handSize());
        Assert.assertEquals(17, players.get(2).handSize());
    }

    @Test
    public void dealsToFourPlayers(){
        List<Player> players = new Dealer().deal(4);

        Assert.assertEquals(13, players.get(0).handSize());
        Assert.assertEquals(13, players.get(1).handSize());
        Assert.assertEquals(13, players.get(2).handSize());
        Assert.assertEquals(13, players.get(3).handSize());
    }
}
