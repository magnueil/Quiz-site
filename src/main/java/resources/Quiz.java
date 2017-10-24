package resources;

import javax.ws.rs.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Magnus on 20/09/2017.
 */
public class Quiz implements Serializable{
    private ArrayList<Question> questions = new ArrayList<Question>();
    private String quizId;
    private String quizName;
    private String startTime;
    private String creatorNick;

    public Quiz() {
    }

    public void setCreatorNick(String creatorNick) {
        this.creatorNick = creatorNick;
    }

    public String getCreatorNick() {
        return creatorNick;
    }

    public Question getQuestion(String qId) {
        for(int i = 0; i < questions.size(); i++) {
            if(questions.get(i).getqId().equals(qId)) {
                return questions.get(i);
            }
        }
        return questions.get(0);
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
            questions.add(q);
        }
    }

    public Object[] getQuestions() {
        return questions.toArray();
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

    public void postQuestion(Question q) {
        questions.add(q);
    }
}
