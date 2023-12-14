package com.steffenboe.aoc;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

class Rock {

    private final UUID id;
    private final Map<Direction, Rock> neighbours = new EnumMap<>(Direction.class);
    private Position position;

    Rock(Position position) {
        id = UUID.randomUUID();
        this.position = position;
    }

    void updateNeighbour(Direction direction, Rock rock) {
        neighbours.put(direction, rock);
    }

    void moveNorth() {
        position = position.move(Direction.NORTH);
        Rock northNeighbor = neighbours.get(Direction.NORTH);
        if (northNeighbor != null) {
            northNeighbor.moveNorth();
        }
    }

    Position position() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("Rock %s, position: %s", id, position);
    }

}
