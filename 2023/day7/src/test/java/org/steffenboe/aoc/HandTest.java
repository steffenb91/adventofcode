package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    void shouldCompareByType() {
        Hand firstHand = new Hand(new Cards("32T3K"), 23);
        Hand secondHand = new Hand(new Cards("T55J5"), 874);
        assertThat(firstHand.compareTo(secondHand), is(-1));
        assertThat(secondHand.compareTo(firstHand), is(1));
        assertThat(secondHand.compareTo(secondHand), is(0));
    }

    @Test
    void shouldCompareByFirstCard() {
        Hand firstHand = new Hand(new Cards("32T3K"), 83);
        Hand secondHand = new Hand(new Cards("T5KJ5"), 66);
        assertThat(firstHand.compareTo(secondHand), is(-1));
        assertThat(secondHand.compareTo(firstHand), is(1));
    }

    @Test
    void shouldCompareBySecondCard() {
        Hand firstHand = new Hand(new Cards("T2T3K"), 1);
        Hand secondHand = new Hand(new Cards("T5KJ5"), 1);
        assertThat(firstHand.compareTo(secondHand), is(-1));
        assertThat(secondHand.compareTo(firstHand), is(1));
    }
}
