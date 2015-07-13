package utils;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 13/07/15 at 22:30.
 */
public class GameUtilTest {

    @Test
    public void testGetWordMap() {
        String word1 = "sampleword";
        String word2 = "aaapl";
        Map<Character, String> word1Map= GameUtil.getWordMap(word1);
        Map<Character, String> word2Map= GameUtil.getWordMap(word2);

        assertNotNull(word1Map);
        assertEquals("0", word1Map.get(Character.valueOf('s')));
        assertEquals("0,1,2", word2Map.get(Character.valueOf('a')));

        assertTrue(word1Map.size() == 10);
    }

    @Test
    public void testGetWordSet() {
        String word1 = "sampleword";
        String word2 = "aaappppllllll";
        Set<Character> word1Set = GameUtil.getWordSet(word1);
        Set<Character> word2Set = GameUtil.getWordSet(word2);

        assertNotNull(word1Set);
        assertNotNull(word2Set);

        assertTrue(word1Set.contains(Character.valueOf('s')));
        assertFalse(word1Set.contains(Character.valueOf('x')));
        assertTrue(word1Set.contains(Character.valueOf('p')));

        assertTrue(word1Set.size() == 10);
        assertTrue(word2Set.size() == 3);
    }
}
