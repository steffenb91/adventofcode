package com.adventofcode.core;

public class Round {

    private Entity player1;
    private Entity player2;

    private static final int EXTRA_POINTS_ON_WIN = 6;
    private static final int EXTRA_POINTS_ON_DRAW = 3;

    public Round(Entity player1, Entity player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getScoreForPlayer2() {
        if (player1.beats(player2)) {
            return calculateScoreAsLooser();
        } else if (player1.equals(player2)) {
            return calculateScoreAsDraw();
        } else {
            return calculateScoreAsWinner();
        }
    }

    private int calculateScoreAsDraw() {
        return player2.getScore() + EXTRA_POINTS_ON_DRAW;
    }

    private int calculateScoreAsWinner() {
        return player2.getScore() + EXTRA_POINTS_ON_WIN;
    }

    private int calculateScoreAsLooser() {
        return player2.getScore();
    }

}
