package com.steffenboe.aoc;

import java.util.HashMap;
import java.util.Map;

class Platform {

    private Map<Position, Rock> rocks = new HashMap<>();

    void addRock(Rock newRock) {
        rocks.put(newRock.position(), newRock);
        Rock neighbor = rocks.get(newRock.position().move(Direction.NORTH));
        newRock.updateNeighbour(Direction.NORTH, neighbor);
    }

}
