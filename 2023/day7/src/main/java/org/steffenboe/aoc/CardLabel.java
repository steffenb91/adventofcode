package org.steffenboe.aoc;

import java.util.List;

enum CardLabel {

    A('A', 13),
    K('K', 12),
    Q('Q', 11),
    J('J', 10),
    T('T', 9),
    NINE('9', 8),
    EIGHT('8', 7),
    SEVEN('7', 6),
    SIX('6', 5),
    FIVE('5', 4),
    FOUR('4', 3),
    THREE('3', 2),
    TWO('2', 1);

    private char label;
    private int rank;

    private CardLabel(char label, int rank) {
        this.label = label;
        this.rank = rank;
    }

    static CardLabel of(char card) {
        return List.of(values()).stream().filter(label -> label.label == card).findFirst().orElseThrow();
    }


    int compareRank(CardLabel other) {
        if(this.equals(CardLabel.J) && !other.equals(CardLabel.J)){
            return -1;
        }
        if(rank > other.rank){
            return 1;
        }
        if(rank < other.rank){
            return -1;
        }
        return 0;
    }

    String asString() {
        return String.valueOf(label);
    }


}
