package wargame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Jen on 3/15/2017.
 */
public class RoundTest {

    @Test
    public void roundWithoutWar(){
        Player player1 = new Player(1);
        Card card1 = new Card(2, "2");
        player1.addCardToHand(card1);
        Player player2 = new Player(2);
        Card card2 = new Card(5, "5");
        player2.addCardToHand(card2);
        Player player3 = new Player(3);
        Card card3 = new Card(4, "4");
        player3.addCardToHand(card3);
        Player winningPlayer = new Player(4);
        Card card4 = new Card(10, "10");
        winningPlayer.addCardToHand(card4);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(winningPlayer);
        RoundResults roundResults = new Round(new SystemOutGameReporter()).playOneRound(players);

        Assert.assertEquals(1, roundResults.getWinners().size());
        Assert.assertEquals(winningPlayer, roundResults.getWinners().get(0));
        Assert.assertEquals(roundResults.getCardsWon().size(), 4);
    }

    @Test
    public void roundWithOneWar(){
        Player player1 = new Player(1);
        Card player1card1 = new Card(2, "2");
        player1.addCardToHand(player1card1);
        Player player2 = new Player(2);
        Card player2card1 = new Card(5, "5");
        player2.addCardToHand(player2card1);
        Player warPlayer = new Player(3);
        Card warPlayerCard1 = new Card(10, "10");
        warPlayer.addCardToHand(warPlayerCard1);
        Card warPlayerFaceDownCard = new Card(8, "8");
        warPlayer.addCardToHand(warPlayerFaceDownCard);
        Card warPlayerCard2 = new Card(5, "5");
        warPlayer.addCardToHand(warPlayerCard2);
        Player winningPlayer = new Player(4);
        Card winningPlayerCard1 = new Card(10, "10");
        winningPlayer.addCardToHand(winningPlayerCard1);
        Card winningPlayerFaceDownCard = new Card(9, "9");
        winningPlayer.addCardToHand(winningPlayerFaceDownCard);
        Card winningPlayerCard2 = new Card(6, "6");
        winningPlayer.addCardToHand(winningPlayerCard2);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(warPlayer);
        players.add(winningPlayer);
        RoundResults roundResults = new Round(new SystemOutGameReporter()).playOneRound(players);

        Assert.assertEquals(1, roundResults.getWinners().size());
        Assert.assertEquals(winningPlayer, roundResults.getWinners().get(0));
        Assert.assertEquals(8, roundResults.getCardsWon().size());
    }

    @Test
    public void roundWithTwoWarsAndMultipleWarringFactions(){
        Player player1 = new Player(1);
        Card player1card1 = new Card(2, "2");
        player1.addCardToHand(player1card1);

        Player player2 = new Player(2);
        Card player2card1 = new Card(10, "10");
        player2.addCardToHand(player2card1);
        Card player2FaceDownCard = new Card(13, "K");
        player2.addCardToHand(player2FaceDownCard);
        Card player2card2 = new Card(2, "2");
        player2.addCardToHand(player2card2);

        Player warPlayer = new Player(3);
        Card warPlayerCard1 = new Card(10, "10");
        warPlayer.addCardToHand(warPlayerCard1);
        Card warPlayerFaceDownCard1 = new Card(8, "8");
        warPlayer.addCardToHand(warPlayerFaceDownCard1);
        Card warPlayerCard2 = new Card(5, "5");
        warPlayer.addCardToHand(warPlayerCard2);
        Card warPlayerFaceDownCard2 = new Card(9, "9");
        warPlayer.addCardToHand(warPlayerFaceDownCard2);
        Card warPlayerCard3 = new Card(2, "2");
        warPlayer.addCardToHand(warPlayerCard3);

        Player winningPlayer = new Player(4);
        Card winningPlayerCard1 = new Card(10, "10");
        winningPlayer.addCardToHand(winningPlayerCard1);
        Card winningPlayerFaceDownCard1 = new Card(12, "Q");
        winningPlayer.addCardToHand(winningPlayerFaceDownCard1);
        Card winningPlayerCard2 = new Card(5, "5");
        winningPlayer.addCardToHand(winningPlayerCard2);
        Card winningPlayerFaceDownCard2 = new Card(12, "Q");
        winningPlayer.addCardToHand(winningPlayerFaceDownCard2);
        Card winningPlayerCard3 = new Card(5, "5");
        winningPlayer.addCardToHand(winningPlayerCard3);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(warPlayer);
        players.add(winningPlayer);
        RoundResults roundResults = new Round(new SystemOutGameReporter()).playOneRound(players);

        Assert.assertEquals(1, roundResults.getWinners().size());
        Assert.assertEquals(winningPlayer, roundResults.getWinners().get(0));
        Assert.assertEquals(14, roundResults.getCardsWon().size());
    }

    @Test
    public void roundWithOneWarAndPlayerRunsOutOfCards(){
        Player player1 = new Player(1);
        Card player1card1 = new Card(2, "2");
        player1.addCardToHand(player1card1);
        Player player2 = new Player(2);
        Card player2card1 = new Card(5, "5");
        player2.addCardToHand(player2card1);
        Player warPlayer = new Player(3);
        Card warPlayerCard1 = new Card(10, "10");
        warPlayer.addCardToHand(warPlayerCard1);
        Player winningPlayer = new Player(4);
        Card winningPlayerCard1 = new Card(10, "10");
        winningPlayer.addCardToHand(winningPlayerCard1);
        Card winningPlayerFaceDownCard = new Card(10, "K");
        winningPlayer.addCardToHand(winningPlayerFaceDownCard);
        Card winningPlayerCard2 = new Card(6, "6");
        winningPlayer.addCardToHand(winningPlayerCard2);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(warPlayer);
        players.add(winningPlayer);
        RoundResults roundResults = new Round(new SystemOutGameReporter()).playOneRound(players);

        Assert.assertEquals(1, roundResults.getWinners().size());
        Assert.assertEquals(winningPlayer, roundResults.getWinners().get(0));
        Assert.assertEquals(6, roundResults.getCardsWon().size());
    }

    @Test
    public void roundWithOneWarAndPlayerRunsOutOfCardsOnDiscard(){
        Player player1 = new Player(1);
        Card player1card1 = new Card(2, "2");
        player1.addCardToHand(player1card1);
        Player player2 = new Player(2);
        Card player2card1 = new Card(5, "5");
        player2.addCardToHand(player2card1);
        Player warPlayer = new Player(3);
        Card warPlayerCard1 = new Card(10, "10");
        warPlayer.addCardToHand(warPlayerCard1);
        Card warPlayerFaceDownCard = new Card(10, "Q");
        warPlayer.addCardToHand(warPlayerFaceDownCard);
        Player winningPlayer = new Player(4);
        Card winningPlayerCard1 = new Card(10, "10");
        winningPlayer.addCardToHand(winningPlayerCard1);
        Card winningPlayerFaceDownCard = new Card(10, "K");
        winningPlayer.addCardToHand(winningPlayerFaceDownCard);
        Card winningPlayerCard2 = new Card(6, "6");
        winningPlayer.addCardToHand(winningPlayerCard2);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(warPlayer);
        players.add(winningPlayer);
        RoundResults roundResults = new Round(new SystemOutGameReporter()).playOneRound(players);

        Assert.assertEquals(1, roundResults.getWinners().size());
        Assert.assertEquals(winningPlayer, roundResults.getWinners().get(0));
        Assert.assertEquals(7, roundResults.getCardsWon().size());
    }

    @Test
    public void roundWithOneWarAndBothPlayersRunOutOfCards(){
        Player player1 = new Player(1);
        Card player1card1 = new Card(2, "2");
        player1.addCardToHand(player1card1);
        Player player2 = new Player(2);
        Card player2card1 = new Card(5, "5");
        player2.addCardToHand(player2card1);
        Player warPlayer = new Player(3);
        Card warPlayerCard1 = new Card(10, "10");
        warPlayer.addCardToHand(warPlayerCard1);
        Card warPlayerCard2 = new Card(6, "6");
        warPlayer.addCardToHand(warPlayerCard2);
        Player winningPlayer = new Player(4);
        Card winningPlayerCard1 = new Card(10, "10");
        winningPlayer.addCardToHand(winningPlayerCard1);
        Card winningPlayerCard2 = new Card(6, "6");
        winningPlayer.addCardToHand(winningPlayerCard2);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(warPlayer);
        players.add(winningPlayer);
        RoundResults roundResults = new Round(new SystemOutGameReporter()).playOneRound(players);

        Assert.assertEquals(2, roundResults.getWinners().size());
        Assert.assertEquals(6, roundResults.getCardsWon().size());
    }
}
