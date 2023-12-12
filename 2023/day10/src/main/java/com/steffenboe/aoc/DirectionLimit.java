package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.List;

class DirectionLimit {

    private List<Direction> validDirections = new ArrayList<>(List.of(Direction.values()));

    DirectionLimit(char identifier) {
        if ('S' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.S);
            validDirections.add(Direction.E);
        }
        if ('|' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.S);
            validDirections.add(Direction.N);
        }
        if ('-' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.E);
            validDirections.add(Direction.W);
        }
        if ('L' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.E);
            validDirections.add(Direction.N);
        }
        if ('J' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.N);
            validDirections.add(Direction.W);
        }
        if ('7' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.S);
            validDirections.add(Direction.W);
        }
        if ('F' == identifier) {
            validDirections = new ArrayList<>();
            validDirections.add(Direction.S);
            validDirections.add(Direction.E);
        }
    }

    public boolean isValid(Direction e) {
        return validDirections.contains(e);
    }
}
