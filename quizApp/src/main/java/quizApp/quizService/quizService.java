package quizApp.quizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quizApp.model.QuestionWrapper;
import quizApp.model.Questions;
import quizApp.model.Quiz;
import quizApp.quizDao.QuizDao;
import quizApp.quizDao.filterQuestionDAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class quizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    filterQuestionDAO filterQuestionDAO;

    /**
     * getAllQuestions functions which fetches all the questions in the response
     * @return List or Questions.
     */
    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(quizDao.findAll(), HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<List<Questions>> getEasyQuestions(String difficultlevel) {
        try {
            return new ResponseEntity<>(quizDao.findByDifficultlevel(difficultlevel), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions questions) {
           quizDao.save(questions);
        return new ResponseEntity<>("successfull Added", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateQuestion(Questions questions) {
        try {
            quizDao.save(questions);
            return new ResponseEntity<>("successfull Updated", HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public ResponseEntity<String> deleteQuestion(Questions questions){
        try {
            quizDao.delete(questions);
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("delete unsccessfull", HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<List<QuestionWrapper>> getAllQuestionsById(Integer id) {
        Optional<Quiz> quiz = filterQuestionDAO.findById(id);
        List<Questions>getQuestionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> getQuestionForUser = new ArrayList<>();

        for(Questions q : getQuestionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestions(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4());
            getQuestionForUser.add(questionWrapper);
        }

        return new ResponseEntity<List<QuestionWrapper>>(getQuestionForUser, HttpStatus.OK);
    }
}
