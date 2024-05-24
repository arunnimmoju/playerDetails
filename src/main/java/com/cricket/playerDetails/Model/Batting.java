package com.cricket.playerDetails.Model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Batting {

    private Integer totalRuns;
    private Integer ballsFaced;
    private Double strikeRate;
    private Double battingAverage;


    public Batting() {
    }

    public Batting(Integer totalRuns, Integer ballsFaced, Double strikeRate, Double battingAverage) {
        this.totalRuns = totalRuns;
        this.ballsFaced = ballsFaced;
        this.strikeRate = strikeRate;
        this.battingAverage = battingAverage;
    }

    @Override
    public String toString() {
        return "Batting{" +
                "totalRuns=" + totalRuns +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", battingAverage=" + battingAverage +
                '}';
    }
}

