package quizApp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String questions;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;

    public QuestionWrapper(Integer id, String questions, String opt1, String opt2, String opt3, String opt4){
         this.id = id;
         this.questions = questions;
         this.opt1 = opt1;
         this.opt2 = opt2;
         this.opt3 = opt3;
         this.opt4 = opt4;
    }
}
