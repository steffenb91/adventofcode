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
        if (!isStationary) {
            return pushNeighbor();
        } 
        return false;
    }

    private boolean pushNeighbor() {
        Direction north = Direction.NORTH;
        Rock northNeighbor = neighbours.get(north);
        if (northNeighbor != null) {
            if (!northNeighbor.isStationary) {
                if(northNeighbor.moveNorth()){
                    position = position.move(Direction.NORTH);
                    return true;
                }
            }
        } else {
            position = position.move(Direction.NORTH);
            return true;
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
