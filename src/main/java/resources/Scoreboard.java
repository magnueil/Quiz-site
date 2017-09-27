package resources;

import java.io.Serializable;

/**
 * Created by Jim on 27.09.2017.
 */
public class Scoreboard implements Serializable {
    private User[] users;
    private int[] scores;
    private Quiz quiz;
    private int index;

    public Scoreboard() {
    }

    private void expandArrays() {
        User[] newArray = new User[users.length*2];
        for(int i = 0; i < users.length; i++) {
            newArray[i] = users[i];
        }
        users = newArray;

        int[] newSArray = new int[scores.length*2];
        for(int i = 0; i < scores.length; i++) {
            newSArray[i] = scores[i];
        }
        scores = newSArray;
    }

    public void addUser(User u, int score) {
        if(index == scores.length-1) {
            expandArrays();
        }
        index++;
        users[index] = u;
        scores[index] = score;
    }

    public void addUser(User u) { //users score is then zero
        if(index == scores.length-1) {
            expandArrays();
        }
        index++;
        users[index] = u;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User[] getUsers() {

        return users;
    }

    public int[] getScores() {
        return scores;
    }

    public Quiz getQuiz() {
        return quiz;
    }
}
