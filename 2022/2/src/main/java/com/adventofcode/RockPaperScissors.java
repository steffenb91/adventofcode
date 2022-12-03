package com.adventofcode;

public enum RockPaperScissors {
    
    ROCK(1), PAPER(2), SCISSORS(3), ERROR(-1);

    private int score;

    RockPaperScissors(int score){
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static RockPaperScissors fromString(String input){
        if("A".equals(input)){
            return ROCK;
        }
        if("B".equals(input)) {
            return PAPER;
        }
        if("C".equals(input)) {
            return SCISSORS;
        }

        throw new IllegalArgumentException(String.format("Could not parse input %s.", input));
    }

    public boolean beats(RockPaperScissors player2) {
        switch(this) {
            case ROCK: 
                return player2.equals(SCISSORS);
            case PAPER:
                return player2.equals(ROCK);
            case SCISSORS:
                return player2.equals(PAPER);
            default:
                return false;
        }
    }

    public static RockPaperScissors withStrategy(RockPaperScissors other, String strategy) {
        if("X".equals(strategy)){
            return shouldLooseAgainst(other);
        }
        if("Y".equals(strategy)) {
            return other;
        }
        if("Z".equals(strategy)){
            return shouldWinAgainst(other);
        }

        throw new IllegalArgumentException(String.format("Could not parse strategy %s.", strategy));
        
    }

    private static RockPaperScissors shouldWinAgainst(RockPaperScissors other) {
        switch(other){
            case ROCK: 
                return PAPER;
            case PAPER:
                return SCISSORS;
            case SCISSORS:
                return ROCK;
            default:
                return ERROR;
        }
    }

    private static RockPaperScissors shouldLooseAgainst(RockPaperScissors other) {
        switch(other){
            case ROCK: 
                return SCISSORS;
            case PAPER:
                return ROCK;
            case SCISSORS:
                return PAPER;
            default:
                return ERROR;
        }
    }

}
