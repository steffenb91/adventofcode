package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    void shouldBeOnePair() {
        Cards cards = new Cards("32T3K");
        assertThat(cards.type(), instanceOf(OnePair.class));
    }

    @Test
    void shouldBeFourOfAKind() {
        Cards cards = new Cards("T6TTT");
        assertThat(cards.type(), instanceOf(FourOfAKind.class));
    }

    @Test
    void shouldBeFiveOfAKind(){
        Cards fiveOfAKind = new Cards("KKKKK");
        assertThat(fiveOfAKind.type(), instanceOf(FiveOfAKind.class));
    }

    @Test
    void shouldBeFullHouse() {
        Cards fullHouse = new Cards("22333");
        assertThat(fullHouse.type(), instanceOf(FullHouse.class));
    }

    @Test
    void shouldBeThreeOfAKind(){
        Cards threeOfAKind = new Cards("67KKK");
        assertThat(threeOfAKind.type(), instanceOf(ThreeOfAKind.class));
    }

    @Test
    void shouldBeTwoPair(){
        Cards twoPairs = new Cards("66KK8");
        assertThat(twoPairs.type(), instanceOf(TwoPairs.class));
    }

    @Test
    void shouldBeHighCard(){
        Cards cards = new Cards("KJ928");
        assertThat(cards.type(), instanceOf(HighCard.class));
    }

    @Test
    void shouldBeaPairWithJoker() {
        Cards cards = new Cards("KJ928");
        assertThat(cards.type(), instanceOf(OnePair.class));

    }
}
