package models.orm.hangman;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import play.db.ebean.Model;
import utils.GameUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 13/07/15 at 13:34.
 *
 *
 */
@Entity(name="game")
public class Game extends Model {

    @Id
    private Integer id;
    private String status = GameUtil.IN_PROGRESS;
    @JsonIgnore
    private String word;

    @Transient
    private Integer wordLength;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String answer;

    @Column(name="start_time")
    private Date startTime;

    @Column(name="failed_guesses")
    private String failedGuesses = "";

    @Column(name="right_guesses")
    private String rightGuesses = "";

    public Game(String word) {
        this.word = word;
        this.startTime = Calendar.getInstance().getTime();
        this.wordLength = word.length();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getFailedGuesses() {
        return failedGuesses;
    }

    public void setFailedGuesses(String failedGuesses) {
        this.failedGuesses = failedGuesses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getRightGuesses() {
        return rightGuesses;
    }

    public void setRightGuesses(String rightGuesses) {
        this.rightGuesses = rightGuesses;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static Finder<Integer, Game> getFind() {
        return find;
    }

    public static void setFind(Finder<Integer, Game> find) {
        Game.find = find;
    }

    public Integer getWordLength() {
        return wordLength;
    }

    public void setWordLength(Integer wordLength) {
        this.wordLength = wordLength;
    }

    public static Game createGame() {
        Game game = new Game(SeedWord.getRandomWord().getWord());
        game.save();
        return game;
    }

    public static Game getGame(Long id){
        Game game = findGameById(id);
        if(game != null)
        game.setWordLength(game.getWord().length());
        return game;
    }

    public static Finder<Integer,Game> find = new Finder<>(
            Integer.class, Game.class
    );

    public static Game findGameById(final Long id) {
        return find
                .where()
                .eq("id", id)
                .findUnique();
    }

    public static List<Game> findAllGames() {
        return find.all();
    }

}
//todo dao shouldn't be accessed directly, create a manager/service layer inbetween then enable caching of some entries