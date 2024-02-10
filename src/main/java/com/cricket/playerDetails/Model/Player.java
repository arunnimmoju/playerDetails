package com.cricket.playerDetails.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cricketPlayer")
public class Player {

    @Id
    private Integer playerId;
    private String playerName;
    private Date playerDob;
    private String playerNationality;
    private Integer totalMatches;
    private String teamsPlayed;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "totalRuns", column = @Column(name = "total_runs")),
            @AttributeOverride(name = "ballsFaced", column = @Column(name = "balls_faced")),
            @AttributeOverride(name = "strikeRate", column = @Column(name = "strike_rate")),
            @AttributeOverride(name = "battingAverage", column = @Column(name = "batting_average"))
    })
    private Batting batting;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "wickets", column = @Column(name = "wickets")),
            @AttributeOverride(name = "bowlingEconomy", column = @Column(name = "bowling_economy")),
            @AttributeOverride(name = "fiveHawl", column = @Column(name = "five_hawl"))
    })
    private Bowling bowling;

    public Player() {
    }

    public Player(Integer playerId, String playerName, Date playerDob, String playerNationality, Integer totalMatches, String teamsPlayed, Batting batting, Bowling bowling) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerDob = playerDob;
        this.playerNationality = playerNationality;
        this.totalMatches = totalMatches;
        this.teamsPlayed = teamsPlayed;
        this.batting = batting;
        this.bowling = bowling;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Date getPlayerDob() {
        return playerDob;
    }

    public void setPlayerDob(Date playerDob) {
        this.playerDob = playerDob;
    }

    public String getPlayerNationality() {
        return playerNationality;
    }

    public void setPlayerNationality(String playerNationality) {
        this.playerNationality = playerNationality;
    }

    public Integer getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Integer totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamsPlayed() {
        return teamsPlayed;
    }

    public void setTeamsPlayed(String teamsPlayed) {
        this.teamsPlayed = teamsPlayed;
    }

    public Batting getBatting() {
        return batting;
    }

    public void setBatting(Batting batting) {
        this.batting = batting;
    }

    public Bowling getBowling() {
        return bowling;
    }

    public void setBowling(Bowling bowling) {
        this.bowling = bowling;
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerDob=" + playerDob +
                ", playerNationality='" + playerNationality + '\'' +
                ", totalMatches=" + totalMatches +
                ", teamsPlayed='" + teamsPlayed + '\'' +
                ", batting=" + batting +
                ", bowling=" + bowling +
                '}';
    }
}
