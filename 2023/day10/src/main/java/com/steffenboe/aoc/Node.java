package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.List;

class Node {

    private List<Connection> connections = new ArrayList<>();
    private boolean visited = false;
    private int distanceToStart = 0;
    private char identifier;

    private DirectionLimit directionLimit;

    Node(char identifier) {
        this.directionLimit = new DirectionLimit(identifier);
    }

    void addNeighbor(Direction e, Node pipe) {
        if (directionLimit.isValid(e)) {
            connections.add(new Connection(e, pipe));
        }
    }

    List<Connection> neighbors(char toExclude) {
        return connections.stream().filter(connection -> toExclude != connection.pipe().identifier).toList();
    }

    Node connection(Direction direction) {
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
