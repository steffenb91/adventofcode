package com.adventofcode;

public class Round {

    private RockPaperScissors player1;
    private RockPaperScissors player2;

    Round(RockPaperScissors player1, RockPaperScissors player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    int getScoreForPlayer2() {
        if (player1.beats(player2)) {
            return calculateScoreAsLooser();
        } else if (player1.equals(player2)) {
            return calculateScoreAsDraw();
        } else {
            return calculateScoreAsWinner();
        }
    }

    private int calculateScoreAsDraw() {
        return player2.getScore() + 3;
    }

    private int calculateScoreAsWinner() {
        return player2.getScore() + 6;
    }

    private int calculateScoreAsLooser() {
        return player2.getScore();
    }

}
