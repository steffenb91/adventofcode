package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.List;

class Node {

    private List<Connection> connections = new ArrayList<>();
    private boolean visited = false;
    private int distanceToStart = 0;
    private char identifier;

    private DirectionLimit directionLimit;
    private Node parent;

    Node(char identifier) {
        this.directionLimit = new DirectionLimit(identifier);
        this.identifier = identifier;
    }

    void addNeighbor(Direction e, Node pipe) {
        if (directionLimit.isValid(e)) {
            connections.add(new Connection(e, pipe));
        }
    }

    List<Connection> neighbors(char toExclude) {
        return connections
                .stream()
                .filter(connection -> toExclude != connection.node().identifier)
                .distinct()
                .toList();
    }

    Node connection(Direction direction) {
        return connections.stream().filter(connection -> direction.equals(connection.direction())).findFirst()
                .orElse(new Connection(Direction.ZERO, this)).node();
    }

    boolean isStart() {
        return 'S' == identifier;
    }

    void visit() {
        this.visited = true;
    }

    boolean isVisited() {
        return visited;
    }

    void setDistanceToStart(int distanceToStart) {
        this.distanceToStart = distanceToStart;
    }

    int getDistanceToStart() {
        return distanceToStart;
    }

    @Override
    public String toString() {
        return "Node: " + identifier;
    }

    void setParent(Node node) {
        this.parent = node;
    }

    Node getParent() {
        return parent;
    }

    char identifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        return this == other;
    }

    public void unvisit() {
        this.visited = false;
        this.connections = new ArrayList<>();
        this.parent = null;
    }

}
