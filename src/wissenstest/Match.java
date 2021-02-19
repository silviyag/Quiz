
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

@Entity
public class Match{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matchId;
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

    public int getMatchId(){
        return matchId;
    }

    public void setMatchId(int matchId){
        this.matchId = matchId;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }
    
    public List<Category> getCategories(){
        return categories;
    }
    
    public void setCategories(List<Category> categories){
        this.categories = categories;
    }
    
    public void addCatgory(Category category){
        categories.add(category);
    }
    
    public void deleteCategoryByPosition(int position){
        categories.remove(position);
    }
    
    public void deleteCategoryById(int categoryId){
        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getCategoryId() == categoryId){
                categories.remove(i);
                break;
            }
        }
    }
    
    public Date getStartDate(){
        return startDate;
    }
    
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
	
    public Date getEndDate(){
        return endDate;
    }
    
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }    
}
