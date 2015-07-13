package models.orm.hangman;

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.db.ebean.Model;
import utils.GameUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 13/07/15 at 06:11.
 *
 *  A dao to manage words
 */

@Entity(name="seed_word")
public class SeedWord extends Model {

    @Id
    private int id;
    private String word;

    @JsonIgnore
    private static List<SeedWord> allSeedWords = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public static Finder<Integer,SeedWord> find = new Finder<>(
            Integer.class, SeedWord.class
    );

    public static SeedWord getRandomWord(){
        if (allSeedWords == null) {
            allSeedWords = findAll();
        }

        return allSeedWords.get(GameUtil.randInt(0, allSeedWords.size() - 1));
    }

    public static List<SeedWord> findAll() {
        return find.all();
    }
}
