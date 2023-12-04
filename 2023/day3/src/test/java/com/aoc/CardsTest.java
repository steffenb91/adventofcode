package com.aoc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CardsTest {

    @Test
    void shouldIncludeCopiesOfCards() {
        List<Integer> winningNumbers = List.of(41, 48, 83, 86, 17);
        List<Integer> actualNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);
        Card card = new Card(1, winningNumbers, actualNumbers);
        Cards cards = new Cards(List.of(card));
        
    }
}
