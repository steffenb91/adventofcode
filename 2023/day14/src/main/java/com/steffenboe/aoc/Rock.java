package com.steffenboe.aoc;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

class Rock {

    private final UUID id;
    private final Map<Direction, Rock> neighbours = new EnumMap<>(Direction.class);
    private Position position;
    private boolean isStationary = false;

    Rock(Position position) {
        id = UUID.randomUUID();
        this.position = position;
    }

    Rock(Position position, boolean isStationary) {
        this(position);
        this.isStationary = isStationary;
    }

    void updateNeighbour(Direction direction, Rock rock) {
        neighbours.put(direction, rock);
    }

    void moveNorth() {
        if (!isStationary) {
            pushNeighbor();
        }
    }

    private void pushNeighbor() {
        Direction north = Direction.NORTH;
        Rock northNeighbor = neighbours.get(north);
        if (northNeighbor != null) {
            if (!northNeighbor.isStationary) {
                position = position.move(Direction.NORTH);
                northNeighbor.moveNorth();
            }
        } else {
            position = position.move(Direction.NORTH);
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
