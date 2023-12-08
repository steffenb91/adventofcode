package org.steffenboe.aoc;

import java.util.List;

class CamelCards {

    private List<Hand> hands;

    public CamelCards(List<Hand> hands) {
        this.hands = hands;
    }

    public int totalWinning() {
        hands.sort((h1, h2) -> {
            return h1.compareTo(h2);
        });
        int result = 0;
        for (int i = 0; i < hands.size(); i++) {
            result += hands.get(i).bid() * (i + 1);
        }
        return result;
    }

    
}
