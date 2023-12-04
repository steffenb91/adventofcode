package com.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void shouldSumUpActualNumbers() {
        List<Integer> winningNumbers = List.of(41, 48, 83, 86, 17);
        List<Integer> actualNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);
        Card card = new Card(1, winningNumbers, actualNumbers);
        assertThat(card.value(), is(8));
    }

    @Test
    void shouldWinCopiesOfScratchcards() {
        List<Integer> winningNumbers = List.of(41, 48, 83, 86, 17);
        List<Integer> actualNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);
        Card card = new Card(1, winningNumbers, actualNumbers);
        assertThat(card.matchingNumbers(), is(4));
    }
}
