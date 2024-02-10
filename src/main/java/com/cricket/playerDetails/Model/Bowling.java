package com.cricket.playerDetails.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Bowling {

    private Integer wickets;
    private Double bowlingEconomy;
    private Integer fiveHawl;


    public Bowling() {
    }

    public Bowling(Integer wickets, Double bowlingEconomy, Integer fiveHawl) {
        this.wickets = wickets;
        this.bowlingEconomy = bowlingEconomy;
        this.fiveHawl = fiveHawl;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Double getBowlingEconomy() {
        return bowlingEconomy;
    }

    public void setBowlingEconomy(Double bowlingEconomy) {
        this.bowlingEconomy = bowlingEconomy;
    }

    public Integer getFiveHawl() {
        return fiveHawl;
    }

    public void setFiveHawl(Integer fiveHawl) {
        this.fiveHawl = fiveHawl;
    }

    @Override
    public String toString() {
        return "Bowling{" +
                "wickets=" + wickets +
                ", bowlingEconomy=" + bowlingEconomy +
                ", fiveHawl=" + fiveHawl +
                '}';
    }
}
