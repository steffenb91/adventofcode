package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class CardLabelTest {

    @Test
    void jshouldBeWeakest() { 
       assertThat(CardLabel.J.compareRank(CardLabel.TWO), is(-1)); 
    }
}
