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
    private int playerId;
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
    public int getPlayerId() {
        return playerId;
    }

    @Setter
    public void setPlayerId(int id) {
        playerId = id;
    }

    @Getter
    public String getPlayerName() {
        return playerName;
    }

    @Setter
    public void setPlayerName(String name) {
        playerName = name;
    }

    @Getter
    public Match getCurrentMatch() {
        return currentMatch;
    }

    @Setter
    public void setCurrentMatch(Match match) {
        currentMatch = match;
    }

    @Getter
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    @Setter
    public void setMatchesPlayed(int matches) {
        matchesPlayed = matches;
    }

    @Getter
    public int getScore() {
        return score;
    }

    @Setter
    public void setScore(int score) {
        this.score = score;
    }

}
