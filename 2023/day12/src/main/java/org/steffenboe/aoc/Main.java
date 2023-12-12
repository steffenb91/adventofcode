package org.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> result = new ArrayList<>();
        Files.readAllLines(Path.of("input.txt")).forEach(line -> {

            String[] split = line.split(" ");
            String pattern = split[0];
            String[] numbers = split[1].split(",");
            int[] nus = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nus[i] = Integer.parseInt(numbers[i]);
            }
            List<String> combinations = new ArrayList<>();
            generateCombinationsHelper(pattern.toCharArray(), 0, combinations);
            combinations.stream().filter(combi -> isValidCombination(combi, nus)).forEach(result::add);
        });
        System.out.println(result.size());
        
        

    }

    private static void generateCombinationsHelper(char[] pattern, int index, List<String> combinations) {
        if (index == pattern.length) {
            combinations.add(new String(pattern));
            return;
        }

        if (pattern[index] == '?') {
            // Replace '?' with '.' and recurse
            pattern[index] = '.';
            generateCombinationsHelper(pattern, index + 1, combinations);

            // Replace '?' with '#' and recurse
            pattern[index] = '#';
            generateCombinationsHelper(pattern, index + 1, combinations);

            // Restore original character for backtracking
            pattern[index] = '?';
        } else {
            // If the character is not '?', move to the next character
            generateCombinationsHelper(pattern, index + 1, combinations);
        }
    }

    private static boolean isValidCombination(String combination, int[] setOfNumbers) {
        String[] groups = combination.split("\\.");

        // Filter out empty groups
        groups = Arrays.stream(groups).filter(s -> !s.isEmpty()).toArray(String[]::new);

        if (groups.length != setOfNumbers.length) {
            return false;
        }

        for (int i = 0; i < groups.length; i++) {
            int groupLength = groups[i].length();
            if (groupLength != setOfNumbers[i]) {
                return false;
            }
        }

        return true;
    }

}
