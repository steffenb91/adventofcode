package com.adventofcode;

class StrategyGuide {

    private Rounds rounds;

    StrategyGuide(Rounds rounds) {
        this.rounds = rounds;
    }

    int getTotalScore() {
        return rounds.getTotalScore();
    }

}
