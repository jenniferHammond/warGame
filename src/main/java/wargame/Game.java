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
            RoundResults roundResults = new Round(gameReporter).playOneRound(activePlayers);
            rewardWinner(roundResults);

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

    private void rewardWinner(RoundResults roundResults) {
        if(!roundResults.isDraw()) {
            Player winningPlayer = roundResults.getWinners().get(0);
            gameReporter.print(winningPlayer + " wins the round!");

            for (Player player : activePlayers) {
                if (player.equals(winningPlayer)) {
                    player.addCardsToHand(roundResults.getCardsWon());
                }
            }
        } else{
            // since the rules aren't super clear on what happens, let's assume we just get rid of
            // those cards, because no one likes playing war for hours anyways.
            gameReporter.print("A draw occurred, throwing these cards out. Them's the breaks.");
        }
    }
}
