package services;

import resources.Question;
import resources.Quiz;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Magnus on 20/09/2017.
 */

@Path("/quizes/")
public class QuizService {
    private static Map<String, Quiz> quizes = new HashMap<String, Quiz>();
    //private static Map<String, Question> questions = new HashMap<String, Question>();

    @GET
    @Path("/{quizId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Quiz getQuiz(@PathParam("quizId") String quizId) {
        if(quizes.containsKey(quizId)) {
            return quizes.get(quizId);
        } else {
            throw new NotFoundException();
        }
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] getQuizes() {
        return quizes.values().toArray();
    }//*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Quiz[] getQuizes() {
        if(quizes.size() > 0) {
            Quiz[] result = new Quiz[quizes.size()];
            Object[] help = quizes.values().toArray();
            for(int i = 0; i < quizes.size();i++) {
                result[i] = (Quiz) help[i];
            }
            return result;
        }
        return null;
    }

    @GET
    @Path("/{quizId}/questions/")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] getQuestions(@PathParam("quizId") String quizId) {
        return quizes.get(quizId).getQuestions();
    }

    @GET
    @Path("/{quizId}/questions/{questionId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Question getQuestion(@PathParam("quizId") String quizId,
            @PathParam("questionId") String questionId) {
        return quizes.get(quizId).getQuestion(questionId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addQuiz(Quiz q) {
        quizes.put(q.getQuizId(),q);
        return q.getQuizId();
    } //TODO check input for erroneous variables

    /*@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addQuiz(@FormParam("quizid") String quizId,
                        @FormParam("quizname") String quizName,
                        @FormParam("starttime") String startTime,
                        @FormParam("creatornick") String creatorNick) {
        Quiz q = new Quiz();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        q.setCreatorNick(creatorNick);
        q.setQuizId(quizId);
        q.setQuizName(quizName);
        q.setStartTime(startTime);
        addQuiz(q);
        System.out.println("The long one was used");
    }//*/

    @POST
    @Path("/{quizId}/questions/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuestion(@PathParam("quizId") String quizId, Question que) {
        if(quizes.containsKey(quizId)) {
            quizes.get(quizId).addQuestion(que);
        } else {
            throw new NotFoundException();
        }
    }
}
