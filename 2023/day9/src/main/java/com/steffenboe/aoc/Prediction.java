package com.steffenboe.aoc;

import java.util.List;

class Prediction {

    private List<Sequence> sequences;

    public Prediction(List<Sequence> sequences) {
        this.sequences = sequences;
        this.sequences.removeIf(sequence -> sequence.isEmpty());
        this.sequences = this.sequences.stream().distinct().toList();
    }

    public int predict() {
        for (int i = sequences.size() - 1; i >= 0; i--) {
            if(i == sequences.size() - 1){
                sequences.get(i).add(0);
            } else {
                sequences.get(i).add(sequences.get(i).last() + sequences.get(i + 1).last());
            }

        }
        return sequences.get(0).last();
    }
    
}
