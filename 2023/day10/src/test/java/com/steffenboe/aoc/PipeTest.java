package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class PipeTest {
    
    @Test
    void shouldIgnoreIfNoConnection() {
        Node first = new Node('|');
        first.addNeighbor(Direction.E, new Node('-'));
        assertThat(first.neighbors('.').size(), is(0));
    }

    @Test
    void shouldAddConnections() {
        Node first = new Node('|');
        first.addNeighbor(Direction.N, new Node('-'));
        first.addNeighbor(Direction.S, new Node('J'));
        assertThat(first.neighbors('.').size(), is(2));
    }

}
