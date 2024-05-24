package com.cricket.playerDetails.Model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Override
    public String toString() {
        return "Bowling{" +
                "wickets=" + wickets +
                ", bowlingEconomy=" + bowlingEconomy +
                ", fiveHawl=" + fiveHawl +
                '}';
    }
}
