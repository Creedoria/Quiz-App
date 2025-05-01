package quizApp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToMany
    private List<Questions> questions;
}
