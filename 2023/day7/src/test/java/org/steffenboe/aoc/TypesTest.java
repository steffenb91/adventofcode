package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class TypesTest {

    @Test
    void fromStrongestToWeakest(){
        assertThat(new FiveOfAKind().isStrongerThan(new FourOfAKind()), is(true));
        assertThat(new FourOfAKind().isStrongerThan(new FullHouse()), is(true));
        assertThat(new FullHouse().isStrongerThan(new ThreeOfAKind()), is(true));
        assertThat(new ThreeOfAKind().isStrongerThan(new TwoPairs()), is(true));
        assertThat(new TwoPairs().isStrongerThan(new OnePair()), is(true));
        assertThat(new OnePair().isStrongerThan(new HighCard()), is(true));
    }
}
