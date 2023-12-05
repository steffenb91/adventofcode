package com.aoc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CardsTest {

    /**
     * The first card has one winning number, so the next card should get copied.
     * The second card has no winning numbers. The total amount of cards should be 3.
     */
    @Test
    void shouldIncludeCopiesOfCards() {
        List<Integer> winningNumbers = List.of(41, 48, 83, 86, 17);
        List<Integer> actualNumbers = List.of(81, 86, 6, 31, 18, 9, 47, 53);
        Card card = new Card(1, winningNumbers, actualNumbers);
        List<Integer> winningNumbers2 = List.of(41, 48, 83, 86, 17);
        List<Integer> actualNumbers2 = List.of(82, 81, 6, 31, 19, 9, 47, 53);
        Card card2 = new Card(2, winningNumbers2, actualNumbers2);
        Cards cards = new Cards(new ArrayList<Card>(List.of(card, card2)));
        assertThat(cards.totalCardCount(), is(3));
    }
}
