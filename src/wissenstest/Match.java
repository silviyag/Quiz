
package wissenstest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
public class Match{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int match_id;
    @OneToOne
    private Player player;
    @OneToMany(mappedBy = "match")
    private List<Category> categories;  //selected categories
    @Temporal(TIMESTAMP)
    private volatile Date startDate;
    @Temporal(TIMESTAMP)
    private volatile Date endDate;
    
    
    public Match(){
        categories = new ArrayList<Category>();
        //getting data from Database
    }

    @Getter
    public int getMatch_id(){
        return match_id;
    }
    @Setter
    public void setMatch_Id(int Match_id){
        match_id = Match_id;
    }

    @Getter
    public Player getPlayer(){
        return player;
    }
    @Setter
    public void setPlayer(Player Player){
        player = Player;
    }
    
    @Getter
    public List<Category> getCategories(){
        return categories;
    }
    @Setter
    public void setCategories(List<Category> Categories){
        categories = Categories;
    }
    
    public void addCatgory(Category Category){
        categories.add(Category);
    }
    
    public void deleteCategoryOnPosition(int position){
        categories.remove(position);
    }
    
    public void deleteCategoryWithID(int ID){
        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getCategory_id() == ID){
                categories.remove(i);
                break;
            }
        }
    }
    
    @Getter
    public Date getStartDate(){
        return startDate;
    }
    @Setter
    public void setStartDate(Date StartDate){
        startDate = StartDate;
    }
	
    @Getter
    public Date getEndDate(){
        return endDate;
    }
    @Setter
    public void setEndDate(Date EndDate){
        endDate = EndDate;
    }    
}
