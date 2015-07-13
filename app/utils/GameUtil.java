package utils;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 13/07/15 at 06:21.
 */
public class GameUtil {

    public static final int TOTAL_LIVES = 8;
    public static final String WON = "won";
    public static final String LOST = "lost";
    public static final String IN_PROGRESS = "inprogress";

    /**
     *
     * Get a random number within a range
     *
     * @param max the maximum random number expected
     * @param min the minimum random number expected
     *
     * @return the random number generated
     * */

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Represent a string as a map of characters to index of characters
     *
     * @param word the word to be represented as a map
     * @return the map containing the characters of the word as keys and index in which they exist in the string as values
     * */
    public static Map<Character, String> getWordMap(String word){
        Map<Character, String> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            //Process char

            if(wordMap.containsKey(c)){
                wordMap.put(c, wordMap.get(c) + "," + i);
            }
            else{
                wordMap.put(c, String.valueOf(i));
            }
        }
        return wordMap;
    }


    /**Cobvert a string to an hashset of it's characters
     *
     * @param word the string to be converted
     * @return the hashset representing the string
     * */
    public static Set<Character> getWordSet(String word){
        Set<Character> characterSet = new HashSet<>(Lists.charactersOf(word));
        return characterSet;
    }
}
