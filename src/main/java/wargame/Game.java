package wargame;

/**
 * Created by Jen on 3/15/2017.
 */
public class Game {
    private IGameReporter gameReporter;

    public Game(IGameReporter gameReporter){
        this.gameReporter = gameReporter;
    }

    public void Play(int numPlayers){
        gameReporter.printTurn("This is war!");
        gameReporter.printTurn("Generating war game for " + numPlayers + " players.");
    }
}
