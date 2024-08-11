package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class CardLabelTest {

    @Test
    void jshouldBeWeakest() { 
       assertThat(Card.J.compareRank(Card.TWO), is(-1)); 
    }
}
