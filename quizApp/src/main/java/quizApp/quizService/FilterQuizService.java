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

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterQuizService {

    @Autowired
    filterQuestionDAO filterQuestionDAO;

    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> getFilteredData(String difficultlevel, int numQ,String title) {
        List<Questions> questions = quizDao.findRandomQuestionsByDiffucult(difficultlevel, numQ);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(questions);
        filterQuestionDAO.save(quiz);

        return new ResponseEntity<>("success Saved", HttpStatus.OK);
    }
}
