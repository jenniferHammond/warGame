package wargame;

import org.junit.Test;

/**
 * Created by Jen on 3/15/2017.
 */
public class GameTest {

    @Test
    public void runGames(){
        for(int i=0; i<500; i++) {
            new Game(new SystemOutGameReporter()).PlayNewGame(4);
        }
    }
}
