package com.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0;
        // TODO hardcoded array dimensions
        Pipe[][] pipes = new Pipe[5][5];
        for (String line : Files.readAllLines(Path.of("input.txt"))) {
            int j = 0;
            for (Character character : line.toCharArray()) {
                pipes[i][j] = new Pipe(character);
                j++;
            }
            i++;
        }
        Grid grid = new Grid(pipes);
        System.out.println(grid.furthestAway());
    }
}