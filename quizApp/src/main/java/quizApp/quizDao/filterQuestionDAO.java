package quizApp.quizDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import quizApp.model.Questions;
import quizApp.model.Quiz;

import java.util.List;

public interface filterQuestionDAO extends JpaRepository<Quiz,Integer> {
}
