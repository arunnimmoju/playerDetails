package com.cricket.playerDetails.Model;

import jakarta.persistence.Embeddable;

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

    public Integer getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(Integer totalRuns) {
        this.totalRuns = totalRuns;
    }

    public Integer getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(Integer ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public Double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(Double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(Double battingAverage) {
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

