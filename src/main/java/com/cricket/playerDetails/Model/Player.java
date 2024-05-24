package com.cricket.playerDetails.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
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
