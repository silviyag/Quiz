package wissenstest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int player_id;
    private String playerName;
    @OneToOne(mappedBy = "player")
    private Match currentMatch;
    private int matchesPlayed;
    private int score;

    public Player() {
        score = 0;
        //getting information from Database by id
    }

    @Getter
    public int getPlayer_id() {
        return player_id;
    }

    @Setter
    public void setPlayer_id(int id) {
        player_id = id;
    }

    @Getter
    public String getPlayerName() {
        return playerName;
    }

    @Setter
    public void setPlayerName(String Name) {
        playerName = Name;
    }

    @Getter
    public Match getCurrentMatch() {
        return currentMatch;
    }

    @Setter
    public void setCurrentMatch(Match Match) {
        currentMatch = Match;
    }

    @Getter
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    @Setter
    public void setMatchesPlayed(int Matches) {
        matchesPlayed = Matches;
    }

    @Getter
    public int getScore() {
        return score;
    }

    @Setter
    public void setScore(int Score) {
        score = Score;
    }

}
