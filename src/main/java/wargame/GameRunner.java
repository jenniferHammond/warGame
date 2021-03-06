package wargame;

/**
 * Created by Jen on 3/15/2017.
 */
public class GameRunner {

    public static void main(String[]args){
        IGameReporter gameReporter = new SystemOutGameReporter();

        if(args.length < 1) {
            gameReporter.print("Please specify number of players.");
            return;
        }

        int numPlayers;

        try {
            numPlayers = Integer.parseInt(args[0]);

            if (numPlayers < 2 || numPlayers > 4) {
                throw new IllegalArgumentException();
            }
        }
        catch(Exception e){
            gameReporter.print("Please specify a valid number of players (2-4).");
            return;
        }

        new Game(gameReporter).PlayNewGame(numPlayers);
    }
}
