package com.adventofcode;

import java.util.List;

class Rounds {

    private List<Round> rounds;

    Rounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public int getTotalScore() {
        return rounds.stream().mapToInt(round -> round.getScoreForPlayer2()).sum();
    }


    
}
