package models.orm.hangman;

import models.orm.hangman.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import play.test.WithApplication;
import static play.test.Helpers.*;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 12/07/15 at 08:27.
 */
public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createAndRetrieveGame() {
        new Game("testword").save();
        Game game = Game.find.where().eq("id", 1).findUnique();
        assertNotNull(game);
        assertEquals("testword", game.getWord());
    }
}