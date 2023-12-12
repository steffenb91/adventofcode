package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Pair {

    private Node first;
    private Node second;

    Pair(Node first, Node second) {
        this.first = first;
        this.second = second;
    }

    Node first() {
        return first;
    }

    Node second() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair other = (Pair) obj;

        // Compare regardless of the order
        return (Objects.equals(first, other.first) && Objects.equals(second, other.second))
                || (Objects.equals(first, other.second) && Objects.equals(second, other.first));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Pair: " + first() + ", " + second();
    }
}
