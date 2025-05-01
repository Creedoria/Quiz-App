package quizApp.QuizController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizApp.model.Questions;
import quizApp.quizService.quizService;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuizController {

    @Autowired
    quizService quizService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestion() {
        return quizService.getAllQuestions();
    };

    @GetMapping("/category/{difficultlevel}")
    public ResponseEntity<List<Questions>> getLevelQuestions(@PathVariable("difficultlevel") String difficultlevel) {
        return quizService.getEasyQuestions(difficultlevel);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String>addQuestion(@RequestBody Questions questions){
       return quizService.addQuestion(questions);
    }

    @PutMapping("updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Questions questions){
        return quizService.updateQuestion(questions);
    }

    @DeleteMapping("deleteQuestion")
    public ResponseEntity<String> deleteQuestion(@RequestBody Questions questions){
        return quizService.deleteQuestion(questions);
    }
}
