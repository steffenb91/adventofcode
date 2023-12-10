package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.List;

class Pipe {

    private List<Connection> connections = new ArrayList<>();
    private List<Direction> validDirections = new ArrayList<>();
    private boolean visited = false;
    private int distanceToStart = 0;
    private char identifier;

    public Pipe(char identifier) {
        this.identifier = identifier;
        if ('S' == identifier) {
            // TODO hardcoded from puzzle input
            validDirections.add(Direction.S);
            validDirections.add(Direction.E);
        }
        if ('|' == identifier) {
            validDirections.add(Direction.S);
            validDirections.add(Direction.N);
        }
        if ('-' == identifier) {
            validDirections.add(Direction.E);
            validDirections.add(Direction.W);
        }
        if ('L' == identifier) {
            validDirections.add(Direction.E);
            validDirections.add(Direction.N);
        }
        if ('J' == identifier) {
            validDirections.add(Direction.N);
            validDirections.add(Direction.W);
        }
        if ('7' == identifier) {
            validDirections.add(Direction.S);
            validDirections.add(Direction.W);
        }
        if ('F' == identifier) {
            validDirections.add(Direction.S);
            validDirections.add(Direction.E);
        }

    }

    public void addNeighbor(Direction e, Pipe pipe) {
        if (validDirections.contains(e)) {
            connections.add(new Connection(e, pipe));
        }
    }

    public List<Connection> neighbors() {
        return connections.stream().filter(connection -> !('.' == connection.pipe().identifier)).toList();
    }

    Pipe connection(Direction direction) {
        return connections.stream().filter(connection -> direction.equals(connection.direction())).findFirst()
                .orElse(new Connection(Direction.ZERO, this)).pipe();
    }

    boolean isStart() {
        return 'S' == identifier;
    }

    void visit() {
        this.visited = true;
        System.out.println("Visited pipe: " + this);
    }

    boolean isVisited() {
        return visited;
    }

    void setDistanceToStart(int distanceToStart) {
        this.distanceToStart = distanceToStart;
        System.out.println("distance to start: " + distanceToStart);
    }

    int getDistanceToStart() {
        return distanceToStart;
    }

    @Override
    public String toString() {
        return "Pipe: " + identifier;
    }

}
