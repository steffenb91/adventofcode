package com.aoc;

import java.util.ArrayList;
import java.util.List;

record Card(int id, List<Integer> winningNumbers, List<Integer> actualNumbers) {

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
    
}
