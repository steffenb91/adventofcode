package com.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Grid grid = new FromTextGridBuilder(Path.of("inputday11.txt")).buildGrid(89, 153);
        System.out.println(grid.sumOfShortestPaths());
    }
}