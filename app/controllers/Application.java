package controllers;

import models.orm.hangman.Game;
import models.response.hangman.PlayResponse;
import models.response.hangman.ValidChars;
import play.mvc.*;

import utils.GameUtil;

import java.util.Map;
import java.util.Set;

import static play.libs.Json.toJson;

public class Application extends Controller {

    /**
     * creates a new game and returns the game data as a json string
     * */
    public static Result createGame() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        return ok(toJson(Game.createGame()));
    }

    /**Load an existing game from the database using the Game id
     *
     * @param id the id of the game to be retrieved
     *
     * @return an http ok response with the game details as a json response
     * */
    public static Result loadGame(Long id) {
        Game currentGame = Game.getGame(id);
        response().setHeader("Access-Control-Allow-Origin", "*");

        if(currentGame==null){
            return ok(toJson("NA"));
        }
        Map<Character, String> wordMap = GameUtil.getWordMap(currentGame.getWord());
        char[] guesses = currentGame.getRightGuesses().toCharArray();
        ValidChars[] validChars = new ValidChars[guesses.length];

        for (int i = 0; i < guesses.length; i++) {
            validChars[i] = new ValidChars(Character.valueOf(guesses[i]), wordMap.get(Character.valueOf(guesses[i])).split(","));
        }
        //add the character indices to the right guesses field so that game state can be fully restored on client side
        currentGame.setRightGuesses(toJson(validChars).toString());

        //if the game is over (not in progress) send the answer to the client
        if(!currentGame.getStatus().equals(GameUtil.IN_PROGRESS)){
            currentGame.setAnswer(currentGame.getWord());
        }
        return ok(toJson(currentGame));
    }

    /**The endpoint that handles a game play
     *
     * @param id the id of the game that is being played
     * @param userChar the character guessed by the user
     *
     * @return the play round response containing information about the game status, if the guess was right or wrong
     * */
    public static Result playGame(Long id, String userChar) {
        Character character = userChar.charAt(0);
        Game currentGame = Game.getGame(id);
        PlayResponse response;
        //ignore used characters
        Set<Character> usedChars = GameUtil.getWordSet(currentGame.getRightGuesses() + currentGame.getFailedGuesses());

        //get word map
        Map<Character, String> wordMap = GameUtil.getWordMap(currentGame.getWord());

        //if the character has been used previously, ignore and return
        if (usedChars.contains(character))
            response = new PlayResponse(currentGame.getStatus(), false, GameUtil.TOTAL_LIVES - currentGame.getFailedGuesses().length());

        //if it's a correct character update game details, check for win and continue
        else if (wordMap.containsKey(character)) {
            String indexes = wordMap.get(character);
            currentGame.setRightGuesses(currentGame.getRightGuesses() + character);

            //check if game is won
            if (currentGame.getRightGuesses().length() == wordMap.size()) {
                currentGame.setStatus(GameUtil.WON);
                response = new PlayResponse(GameUtil.WON, true, indexes, GameUtil.TOTAL_LIVES - currentGame.getFailedGuesses().length());
                response.setAnswer(currentGame.getWord());
            } else {
                response = new PlayResponse(GameUtil.IN_PROGRESS, true, indexes, GameUtil.TOTAL_LIVES - currentGame.getFailedGuesses().length());
            }
        }
        //if it's a wrong character update game data and check if game is lost
        else {
            currentGame.setFailedGuesses(currentGame.getFailedGuesses() + character);
            int failedCount = GameUtil.TOTAL_LIVES - currentGame.getFailedGuesses().length();

            //check if game has been lost
            if (currentGame.getFailedGuesses().length() >= GameUtil.TOTAL_LIVES) {
                response = new PlayResponse(GameUtil.LOST, false, failedCount);
                response.setAnswer(currentGame.getWord());
                currentGame.setStatus(GameUtil.LOST);
            } else {
                response = new PlayResponse(GameUtil.IN_PROGRESS, false, failedCount);
            }
        }

        currentGame.save();
        response().setHeader("Access-Control-Allow-Origin", "*");
        return ok(toJson(response));
    }

    /**
     * Return a list of all games that have been played with their states as a json string
     */
    public static Result management() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        return ok(toJson(Game.findAllGames()));
    }

}
