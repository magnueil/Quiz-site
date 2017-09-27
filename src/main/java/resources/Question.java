package resources;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Magnus on 20/09/2017.
 */
public class Question implements Serializable{
    private String qId;
    private String qText;
    private int qTime;
    private String picURL;
    private String[] qOptions = new String[8];
    private int qAnswer;

    public Question() {
    }

    public boolean equals(Question q) {
        return q.getqId().equals(qId);
    }

    public String getqText() {
        return qText;
    }

    public int getqTime() {
        return qTime;
    }

    public String getPicURL() {
        return picURL;
    }

    public String[] getqOptions() {
        return qOptions;
    }

    public int getQAnswer() {
        return qAnswer;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public void setqTime(int qTime) {
        this.qTime = qTime;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public void setqOptions(String[] qOptions) {
        this.qOptions = qOptions;
    }

    public void setQAnswer(int qAnswer) {
        this.qAnswer = qAnswer;
    }
}
