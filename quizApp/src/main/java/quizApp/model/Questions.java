package quizApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questions;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String answer;
    private String category;
    private String difficultlevel;
}
