package resources;

import javax.ws.rs.NotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Magnus on 20/09/2017.
 */
public class Quiz implements Serializable{
    private Map<String,Question> questions = new HashMap<String,Question>();
    private String quizId;
    private String quizName;
    private String startTime;
    private String creatorNick;

    public Quiz() {
    }

    public boolean hasQuestion(String questionId) {
        return questions.containsKey(questionId);
    }

    public void setCreatorNick(String creatorNick) {
        this.creatorNick = creatorNick;
    }

    public String getCreatorNick() {
        return creatorNick;
    }

    public Question getQuestion(String qId) {
        if(questions.containsKey(qId)) {
            return questions.get(qId);
        } else {
            throw new NotFoundException();
        }
    }

    public String getQuizId() {
        return quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void addQuestion(Question q) {
        if(q!=null) {
            questions.put(q.getqId(),q);
        }
    }

    public Map<String, Question> getQuestions() {
        return questions;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
