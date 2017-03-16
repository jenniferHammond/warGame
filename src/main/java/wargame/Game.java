package wargame;

import java.util.*;

/**
 * Created by Jen on 3/15/2017.
 */
public class Game {
    private IGameReporter gameReporter;

    private List<Player> activePlayers;

    public Game(IGameReporter gameReporter){
        this.gameReporter = gameReporter;
    }

    public void PlayNewGame(int numPlayers){
        gameReporter.print("This is war!");
        gameReporter.print("Generating war game for " + numPlayers + " players.");

        activePlayers = new Dealer().deal(numPlayers);

        gameReporter.print("Starting game for " + numPlayers + " players.");

        int roundNumber = 1;
        while(activePlayers.size() > 1){
            gameReporter.print("\nRound "+roundNumber+":");
            RoundWinner roundWinner = new Round(gameReporter).playOneRound(activePlayers);
            rewardWinner(roundWinner);

            List<Player> players = new ArrayList<Player>(activePlayers);
            for(Player player: players){
                if (!player.hasCards()){
                    gameReporter.print(player + " has run out of cards and is out of the game.");
                    activePlayers.remove(player);
                }
            }
            roundNumber++;
        }

        gameReporter.print(activePlayers.get(0) + " has won the game!");
    }

    private void rewardWinner(RoundWinner roundWinner) {
        Player winningPlayer = roundWinner.getWinner();
        gameReporter.print(winningPlayer + " wins the round!");

        for(Player player: activePlayers){
            if (player.equals(winningPlayer)){
                player.addCardsToHand(roundWinner.getCardsWon());
            }
        }
    }
}
