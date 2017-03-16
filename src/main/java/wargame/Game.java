package wargame;

import java.util.List;

/**
 * Created by Jen on 3/15/2017.
 */
public class Game {
    private IGameReporter gameReporter;

    private List<Player> activePlayers;

    public Game(IGameReporter gameReporter){
        this.gameReporter = gameReporter;
    }

    public void Play(int numPlayers){
        gameReporter.printTurn("This is war!");
        gameReporter.printTurn("Generating war game for " + numPlayers + " players.");

        activePlayers = new Dealer().deal(numPlayers);

        gameReporter.printTurn("Starting game for " + numPlayers + " players.");
    }
}
