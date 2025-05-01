package quizApp.quizDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quizApp.model.Questions;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Questions, BigInteger> {
    List<Questions> findByDifficultlevel(String difficultlevel);

    @Query(value="SELECT * FROM questions q WHERE q.difficultlevel=:difficultlevel ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Questions> findRandomQuestionsByDiffucult(String difficultlevel, int numQ);
}
