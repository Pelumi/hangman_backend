package models.response.hangman;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 13/07/15 at 11:20.
 */
public class PlayResponse {
    private String state; //won, lost, inprogress
    private String indices;
    private Boolean status;
    private Integer lives;
    //don't return the answer to the client unless it's set, the answer is only set when the game ends
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String answer;

    public PlayResponse(String state, Boolean status, String indices, Integer lives) {
        this.state = state;
        this.indices = indices;
        this.status = status;
        this.lives = lives;
    }

    public PlayResponse(String state, Boolean status, Integer lives) {
        this.state = state;
        this.lives = lives;
        this.status = status;
    }

    public String getIndices() {
        return indices;
    }

    public void setIndices(String indices) {
        this.indices = indices;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
