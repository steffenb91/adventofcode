package com.adventofcode.rockpaperscissors;

import javax.management.RuntimeErrorException;

import com.adventofcode.core.Entity;

public enum RockPaperScissorsGame {

    ROCK("A", "Rock", 1),
    PAPER("B", "Paper", 2),
    SCISSORS("C", "Scissors", 3);

    private String name;
    private String id;
    private int score;

    private RockPaperScissorsGame(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Entity getEntity() {
        switch (this) {
            case ROCK:
                return fromString(ROCK.id);
            case PAPER:
                return fromString(PAPER.id);
            case SCISSORS:
                return fromString(SCISSORS.id);
        }
        throw new RuntimeErrorException(new Error());
    }

    public static Entity fromString(String input) {
        if (ROCK.id.equals(input)) {
            return new Entity(ROCK.name, SCISSORS.name, ROCK.score);
        }
        if (PAPER.id.equals(input)) {
            return new Entity(PAPER.name, ROCK.name, PAPER.score);
        }
        if (SCISSORS.id.equals(input)) {
            return new Entity(SCISSORS.name, PAPER.name, SCISSORS.score);
        }

        throw new IllegalArgumentException(String.format("Could not parse input %s.", input));
    }

}
