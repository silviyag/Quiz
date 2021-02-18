
package wissenstest;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private int index;
    List<String> analyseData;
    List<String> indexOfAnswers;
    @OneToMany(mappedBy = "analyse")
    private int playerId;

    public Analyse() {
    }

    Analyse(int playerId) {//int index
        //  this.index = index;
        this.playerId = playerId;
        // analyseData.add(String.valueOf(index) + String.valueOf(playerId));
    }

    // int getIndex() {
    //   return index;
    //}
    public void setAnalyseData(List<String> a) {
        this.analyseData = a;
    }

    List<String> getAnalyseData() {
        return analyseData;
    }

    public void setIndexOfAnswers(List<String> a) {
        this.indexOfAnswers = a;
    }

    public List<String> getIndexOfAnswers() {
        return indexOfAnswers;
    }
}
