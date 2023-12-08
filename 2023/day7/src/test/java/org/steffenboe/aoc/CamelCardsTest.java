package org.steffenboe.aoc;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

class CamelCardsTest {

    @Test
    void shouldSortHands() {
        CamelCards camelCards = new CamelCards(new ArrayList<>(List.of(new Hand(new Cards("32T3K"), 765),
                new Hand(new Cards("T55J5"), 684),
                new Hand(new Cards("KK677"), 28),
                new Hand(new Cards("KTJJT"), 220),
                new Hand(new Cards("QQQJA"), 483))));
		assertThat(camelCards.totalWinning(), is(6440));
    }
}
