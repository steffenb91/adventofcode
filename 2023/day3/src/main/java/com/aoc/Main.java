package com.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Card> cards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("Card\\s*\\d+: ", "");
                String[] split = line.split("\\|");
                List<String> winningNumbers = List.of(split[0].strip().split(" ")).stream().filter(x -> !x.isEmpty() && !x.isBlank() && !x.equals("\"")).toList();
                List<String> actualNumbers = List.of(split[1].strip().split(" ")).stream()
                        .filter(x -> !x.isEmpty() && !x.isBlank() && !x.equals("\"")).toList();
                cards.add(new Card(i++, winningNumbers.stream().map(Integer::parseInt).toList(),
                        actualNumbers.stream().map(Integer::parseInt).toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Cards(cards).scoresWithCopies());
    }
}