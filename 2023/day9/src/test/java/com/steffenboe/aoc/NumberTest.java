package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void shouldBreed() {
        Sequence sequence = new Sequence(
                List.of(new Number(0),
                        new Number(3),
                        new Number(6),
                        new Number(9),
                        new Number(12),
                        new Number(15)));
        List<Sequence> children = sequence.generateChildSequence();
        Sequence firstChild = new Sequence(List.of(new Number(3),
                new Number(3),
                new Number(3),
                new Number(3),
                new Number(3)));
        Sequence secondChild = new Sequence(List.of(new Number(0),
                new Number(0),
                new Number(0),
                new Number(0)));
        assertThat(children, hasItem(firstChild));
        assertThat(children, hasItem(secondChild));
        assertThat(children, hasItem(sequence));
    }

    @Test
    void anotherTest() {
        Sequence sequence = new Sequence(
                List.of(new Number(1),
                        new Number(3),
                        new Number(6),
                        new Number(10),
                        new Number(15),
                        new Number(21)));
        List<Sequence> children = sequence.generateChildSequence();
        Sequence firstChild = new Sequence(List.of(new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)));
        Sequence secondChild = new Sequence(List.of(new Number(1),
                new Number(1),
                new Number(1),
                new Number(1)));
        Sequence thirdChild = new Sequence(List.of(new Number(0),
                new Number(0),
                new Number(0)));
        assertThat(children, hasItem(firstChild));
        assertThat(children, hasItem(secondChild));
        assertThat(children, hasItem(thirdChild));
    }

}
