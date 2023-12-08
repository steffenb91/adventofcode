package org.steffenboe.aoc;

record Node(String id, String left, String right) {

    public Node copy() {
        return new Node(id, left, right);
    }

}
