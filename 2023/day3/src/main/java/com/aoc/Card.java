package com.aoc;

import java.util.ArrayList;
import java.util.List;

class Card {

    private final int id;
    private final List<Integer> winningNumbers;
    private final List<Integer> actualNumbers;

    private List<Card> children = new ArrayList<>();

    Card(int id, List<Integer> winningNumbers, List<Integer> actualNumbers){
        this.id = id;
        this.winningNumbers = winningNumbers;
        this.actualNumbers = actualNumbers;
    }

    public int value() {
        int count = matchingNumbers();
        int value = 0;
        for (int i = 1; i <= count; i++) {
            if(i == 1){
                value += 1;
            } else {
                value = value * 2;
            }
        }
        return value;
    }

    int matchingNumbers() {
        return (int) winningNumbers.stream().filter(actualNumbers::contains).count();
    }

    Card copy(){
        return new Card(id, new ArrayList<>(winningNumbers), new ArrayList<>(actualNumbers));
    }

    int id() {
        return id;
    }

    List<Card> breed(List<Card> cards) {
        List<Card> copies = createChildren(cards);
        return copies;
    }

    private List<Card> createChildren(List<Card> cards) {
        List<Card> copies = new ArrayList<>();
        for (int i = 0; i < matchingNumbers(); i++) {
            Card copy = cards.get(i + 1);
            copies.add(copy.copy());
            copies.addAll(copy.createChildren(copies));
        }
        return copies;
    }

    


    
}
