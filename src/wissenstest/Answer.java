
package wissenstest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
public class Answer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// to configure the way of increment of the specified column(field). Get the next unique primary key for the entities
    private int answer_id;
    @ManyToOne
    private Question question;//many answer to one question
    private String answerText;
    
    public Answer(){
    	  //default
    }
    
    public Answer(String AnswerText){
        answerText = AnswerText;
    }
    
    @Getter
    public int getAnswer_id(){
        return answer_id;
    }
    @Setter
    public void setAnswer_id(int id){
        answer_id = id;
    }
    
    @Getter
    public Question getQuestion(){
        return question;
    }
    @Setter
    public void setQuestion(Question Question){
        question = Question;
    }
    
    @Getter
    public String getAnswerText(){
        return answerText;
    }
    @Setter
    public void setAnswerText(String Text){
        answerText = Text;
    }
}
