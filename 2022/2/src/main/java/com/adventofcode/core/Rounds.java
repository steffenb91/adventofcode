package com.adventofcode.core;

import java.util.List;

public class Rounds {

    private List<Round> rounds;

    public Rounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public int getTotalScore() {
        return rounds.stream()
                .mapToInt(round -> round.getScoreForPlayer2())
                .sum();
    }


    
}
