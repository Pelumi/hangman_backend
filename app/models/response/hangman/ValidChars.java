package models.response.hangman;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 13/07/15 at 16:22.
 *
 * A pojo representing characters in words and an array of the indices in which they exist
 */
public class ValidChars {
    Character guess;
    String[] index;

    public ValidChars(Character guess, String[] index) {
        this.guess = guess;
        this.index = index;
    }

    public Character getGuess() {
        return guess;
    }

    public void setGuess(Character guess) {
        this.guess = guess;
    }

    public String[] getIndex() {
        return index;
    }

    public void setIndex(String[] index) {
        this.index = index;
    }
}
