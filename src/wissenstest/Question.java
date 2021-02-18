package wissenstest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
public class Question {

    @Id
    private int questionId;
    private int questionNumber;
    @ManyToOne
    private Category category;//many questions to one category
    private String questionText;
    @OneToMany(mappedBy = "question")//specifies that the 'question' field  owns the relationship (i.e. contains the foreign key for the query to find all answers for a question.)
    private List<Answer> answers;
    private int tippedAnswer;
    private int correctAnswer;

    public Question() {
          //default
    }

    public Question(int question_id, Category category, String questionText, Answer answer1, Answer answer2, Answer answer3, Answer answer4, int correctAnswer) {
        this.questionId = question_id;
        this.category = category;
        this.questionText = questionText;
        answers = new ArrayList<Answer>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        this.correctAnswer = correctAnswer;
    }

    @Getter
    public int getQuestionId() {
        return questionId;
    }

    @Setter
    public void setQuestion_id(int questionId) {
        this.questionId = questionId;
    }

    @Getter
    public Category getCategory() {
        return this.category;
    }

    @Setter
    public void setCategory(Category category) {
        this.category = category;
    }

    @Getter
    public String getQuestionText() {
        return questionText;
    }

    @Setter
    public void setQuestionText(String text) {
        this.questionText = text;
    }

    @Getter
    public List<Answer> getAnswers() {
        return answers;
    }

    @Setter
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Getter
    public int getTippedAnswer() {
        return tippedAnswer;    //Number of tipped Answer
    }

    @Setter
    public void setTippedAnswer(int tippedAnswer) {
        this.tippedAnswer = tippedAnswer;    //Number of tipped Answer
    }

    @Getter
    public int getCorrectAnswer() {
        return correctAnswer;    //Number of correct Answer
    }

    @Setter
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;    //Number of correct Answer
    }
    @Setter
    void setNumberOfQuestions(int numberOfQuestions) {
        this.questionNumber = numberOfQuestions;
    }
    
    @Getter
    public int getNumberOfQuestions() {
        return this.questionNumber;
    }
}
