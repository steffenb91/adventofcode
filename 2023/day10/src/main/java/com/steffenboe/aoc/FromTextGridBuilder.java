package com.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FromTextGridBuilder {

    private Path path;

    FromTextGridBuilder(Path path){
        this.path = path;
    }

    public Grid buildGrid(int rows, int columns) throws IOException {
        Node[][] pipes = new Node[rows][columns];
        int i = 0;
        for (String line : Files.readAllLines(path)) {
            int j = 0;
            for (Character character : line.toCharArray()) {
                pipes[i][j] = new Node(character);
                j++;
            }
            i++;
        }
        return new Grid(pipes);
    }

    
}
