package quizApp.QuizController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizApp.model.QuestionWrapper;
import quizApp.model.Quiz;
import quizApp.quizService.FilterQuizService;
import quizApp.quizService.quizService;

import java.util.List;

@RestController
@RequestMapping("question")
public class GetQuizController {

    @Autowired
    FilterQuizService filterQuizService;

    @Autowired
    quizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createFilterQuestions(@RequestParam String difficultlevel, @RequestParam int numQ, @RequestParam String title){
        System.out.println("display params :"+" "+difficultlevel+" "+ numQ+" "+title);
        return filterQuizService.getFilteredData(difficultlevel, numQ, title);
    }

    @GetMapping("getQuizById/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@PathVariable Integer id){
        return quizService.getAllQuestionsById(id);
    }
}
