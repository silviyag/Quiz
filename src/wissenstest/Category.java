package wissenstest;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private int categoryNumber; 
    @ManyToOne
    private Match match;
    @OneToMany(mappedBy = "category")//bidirectional association. category is owner of this relationship
    private List<Question> questions;
    private String categoryTitle;
    private boolean selected;

    public Category() {
           //default
    }

    public Category(String categoryTitle) {
        this.questions = new ArrayList<Question>();
        this.categoryTitle = categoryTitle;
        this.selected = false;
    }

    public int getCategoryId() {
        return this.categoryId;
    }


    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Match getMatch() {
        return this.match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(Vector<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void deleteQuestionByPosition(int position) {
        this.questions.remove(position);
    }

    public void deleteQuestionById(int id) {
        for (int i = 0; i < this.questions.size(); i++) {
            if (this.questions.get(i).getQuestionId() == id) {
            	this.questions.remove(i);
                break;
            }
        }
    }

    public String getCategoryTitle() {
        return this.categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
    	  this.categoryTitle = categoryTitle;
    }

    public boolean isSelected() { 
        return this.selected;
    }

    public void setSelected(boolean selected) { 
    	this.selected = selected;
    }
    
    public int getNumberOfCategories() { 
        return this.categoryNumber;
    }
    
    void setNumberOfCategories(int numberOfCategory) { 
        this.categoryNumber = numberOfCategory; 
    } 
}
