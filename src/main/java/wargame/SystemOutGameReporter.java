package wargame;

/**
 * Created by Jen on 3/15/2017.
 */
public class SystemOutGameReporter implements IGameReporter {
    public void printTurn(String turn) {
        System.out.println(turn);
    }
}
