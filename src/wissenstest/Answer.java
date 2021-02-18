
package wissenstest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// to configure the way of increment of the specified column(field). Get the next unique primary key for the entities
    private int answerId;
    @ManyToOne
    private Question question;//many answer to one question
    private String answerText;
    
    public Answer(){
    	  //default
    }
    
    public Answer(String answerText){
        this.answerText = answerText;
    }
    
    @Getter
    public int getAnswerId(){
        return this.answerId;
    }
    @Setter
    public void setAnswerId(int id){
        this.answerId = id;
    }
    
    @Getter
    public Question getQuestion(){
        return this.question;
    }
    @Setter
    public void setQuestion(Question question){
        this.question = question;
    }
    
    @Getter
    public String getAnswerText(){
        return answerText;
    }
    
    @Setter
    public void setAnswerText(String text){
        answerText = text;
    }
}
