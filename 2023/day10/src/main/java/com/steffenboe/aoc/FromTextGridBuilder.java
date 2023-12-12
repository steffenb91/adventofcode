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
        Node[][] nodes = new Node[rows][columns];
        int i = 0;
        for (String line : Files.readAllLines(path)) {
            int j = 0;
            for (Character character : line.toCharArray()) {
                nodes[i][j] = new Node(character, i, j);
                j++;
            }
            i++;
        }
        return new Grid(nodes);
    }

    
}
