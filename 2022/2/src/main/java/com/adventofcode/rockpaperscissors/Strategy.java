package com.adventofcode.rockpaperscissors;

import com.adventofcode.core.Entity;

public enum Strategy {

    WIN("Y"), LOOSE("X"), DRAW("Z");

    private String id;

    Strategy(String id) {
        this.id = id;
    }

    public static Strategy fromString(String id) {
        for (Strategy strategy : values()) {
            if (strategy.id.equals(id)) {
                return strategy;
            }
        }
        throw new IllegalArgumentException(String.format("Could not parse strategy from id: %s.", id));
    }

    public Entity getEntity(Entity other) {
        switch (this) {
            case WIN:
                return shouldWinAgainst(other);
            case LOOSE:
                return shouldLooseAgainst(other);
            case DRAW:
                return other;
        }
        throw new IllegalArgumentException(getErrorMessageForUnknownName(other));
    }

    private Entity shouldLooseAgainst(Entity other) {
        if (other.getName().equals(RockPaperScissorsGame.ROCK.getName())) {
            return RockPaperScissorsGame.SCISSORS.getEntity();
        }
        if (other.getName().equals(RockPaperScissorsGame.PAPER.getName())) {
            return RockPaperScissorsGame.ROCK.getEntity();
        }
        if (other.getName().equals(RockPaperScissorsGame.SCISSORS.getName())) {
            return RockPaperScissorsGame.PAPER.getEntity();
        }
        throw new IllegalArgumentException(getErrorMessageForUnknownName(other));
    }

    private Entity shouldWinAgainst(Entity other) {
        if (other.getName().equals(RockPaperScissorsGame.ROCK.getName())) {
            return RockPaperScissorsGame.PAPER.getEntity();
        }
        if (other.getName().equals(RockPaperScissorsGame.PAPER.getName())) {
            return RockPaperScissorsGame.SCISSORS.getEntity();
        }
        if (other.getName().equals(RockPaperScissorsGame.SCISSORS.getName())) {
            return RockPaperScissorsGame.ROCK.getEntity();
        }

        throw new IllegalArgumentException(getErrorMessageForUnknownName(other));
    }

    private String getErrorMessageForUnknownName(Entity other) {
        return String.format("Could not apply strategy to entity with name %s, reason: unknown name", other.getName());
    }

}
