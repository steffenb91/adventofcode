package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PredictionTest {

    @Test
    void shouldPredict() {
        Sequence sequence = new Sequence(
                new ArrayList<>(List.of(new Number(0),
                        new Number(3),
                        new Number(6),
                        new Number(9),
                        new Number(12),
                        new Number(15))));
        Prediction prediction = new Prediction(sequence.generateChildSequence());
        assertThat(prediction.predict(), is(18));
    }
}
