package wissenstest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestion_id(int questionId) {
        this.questionId = questionId;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String text) {
        this.questionText = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getTippedAnswer() {
        return tippedAnswer;    //Number of tipped Answer
    }

    public void setTippedAnswer(int tippedAnswer) {
        this.tippedAnswer = tippedAnswer;    //Number of tipped Answer
    }

    public int getCorrectAnswer() {
        return correctAnswer;    //Number of correct Answer
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;    //Number of correct Answer
    }

    void setNumberOfQuestions(int numberOfQuestions) {
        this.questionNumber = numberOfQuestions;
    }
    
    public int getNumberOfQuestions() {
        return this.questionNumber;
    }
}
