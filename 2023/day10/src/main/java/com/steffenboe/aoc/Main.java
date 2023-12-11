package com.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0;
        // TODO hardcoded array dimensions
        
        Grid grid = new FromTextGridBuilder(Path.of("input.txt")).buildGrid(5, 5);
        System.out.println(grid.furthestAway());
    }
}