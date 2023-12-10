package com.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Sequence> sequences = new ArrayList<>();
        Files.readAllLines(Path.of("input.txt")).forEach(line -> {
            List<Number> values = new ArrayList<>();
            String[] split = line.split(" ");
            for (int i = 0; i < split.length; i++) {
                int int1 = Integer.parseInt(split[i]);
                values.add(new Number(int1));
            }
            sequences.add(new Sequence(values));
        });
        int sum = sequences.stream().mapToInt(sequence -> {
            Prediction prediction = new Prediction(sequence.generateChildSequence());
            return prediction.predict();
        }).sum();
        System.out.println(sum);
    }
}