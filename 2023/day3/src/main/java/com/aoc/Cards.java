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
    int scoresWithCopies() {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            for (int j = 1; j <= card.matchingNumbers(); j++) {
                Card copy = cards.get(i + j).copy();
                cards.add(i + 1, copy);
                System.out.println("Adding copy of card " + copy.id() + " to position " + (i + j));
            }
        }
        return cards.size();
    }
}
