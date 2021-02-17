package wissenstest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Objects.hash;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;
    private int categoryNumber;
    @ManyToOne
    private Match match;
    @OneToMany(mappedBy = "category")
    private List<Question> questions;
    private String categoryTitle;
    private boolean selected;

    public Category() {

    }

    public Category(String CategoryTitle) {
        //toDo: Switch case je nach CategoryTitle machen um category_id zu setzen
        questions = new ArrayList<Question>();
        categoryTitle = CategoryTitle;
        selected = false;
    }

    @Getter
    public int getCategory_id() {
        return category_id;
    }

    @Setter
    public void setCategory_id(int Category_id) {
        category_id = Category_id;
    }

    @Getter
    public Match getMatch() {
        return match;
    }

    @Setter
    public void setMatch(Match Match) {
        match = Match;
    }

    @Getter
    public List<Question> getQuestions() {
        return questions;
    }

    @Setter
    public void setQuestions(Vector<Question> Questions) {
        questions = Questions;
    }

    public void addQuestion(Question Question) {
        questions.add(Question);
    }

    public void deleteQuestionOnPosition(int position) {
        questions.remove(position);
    }

    public void deleteQuestionWithID(int ID) {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getQuestion_id() == ID) {
                questions.remove(i);
                break;
            }
        }
    }

    @Getter
    public String getCategoryTitle() {
        return categoryTitle;
    }

    @Setter
    public void setCategoryTitle(String Title) {
        categoryTitle = Title;
    }

    @Getter
    public boolean isSelected() {    //0 = false, 1 = true
        return selected;
    }

    @Setter
    public void setSelected(boolean Selected) {  //0 = false, 1 = true
        selected = Selected;
    }

    void setNumberOfCategories(int numberOfCategory) {
        this.categoryNumber = numberOfCategory;
    }
}
