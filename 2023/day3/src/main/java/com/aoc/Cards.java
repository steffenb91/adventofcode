package com.aoc;

import java.util.List;

public class Cards {

    private List<Card> cards;
    private List<Integer> ids;

    Cards(List<Card> cards) {
        this.cards = cards;
        this.ids = cards.stream().map(Card::id).toList();
    }

    int scores() {
        return cards.stream().mapToInt(Card::value).sum();
    }

    // TODO
    // make each card know all following cards
    // each card can "breed" x following cards, depending on the number of matches it has
    // in the end, each original and each copied card needs to "breed" to get the total amount of cards
    // after each "breeding", the copies need to breed themself
    int totalCardCount() {
        for (Card card : cards) {
            card.breed(cards);
        }

        return 0;
    }
}
