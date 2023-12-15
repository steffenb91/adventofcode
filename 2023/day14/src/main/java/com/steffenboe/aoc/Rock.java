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

    public boolean moveNorth() {
        if (position.x() == 0) {
            return false;
        }
        Rock northNeighbor = this.neighbours.get(Direction.NORTH);
        if (!isStationary && northNeighbor == null) {
            return move();
        } else if (northNeighbor.position.x() != position.x() - 1) {
            return move();
        } else {
            return false;
        }
    }

    private boolean move() {
        position = position.move(Direction.NORTH);
        return true;
    }

    private boolean pushNeighbor() {
        Direction north = Direction.NORTH;
        Rock northNeighbor = neighbours.get(north);
        if (northNeighbor != null) {
            if (!northNeighbor.isStationary) {
                if (northNeighbor.moveNorth()) {
                    return move();
                }
            }
        } else {
            return move();
        }
        return false;
    }

    Position position() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("Rock %s, position: %s", id, position);
    }

    public boolean isStationary() {
        return isStationary;
    }

}
