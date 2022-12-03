package com.adventofcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class PuzzleReader {

    private File file;

    PuzzleReader(File file) {
        this.file = file;
    }

    Rucksacks readPuzzle() throws IOException {
        String puzzle = Files.readString(file.toPath());
        List<Rucksack> rucksacks = new ArrayList<>();
        for (String line : puzzle.split("\\n")) {
            rucksacks.add(new Rucksack(line));
        }
        return new Rucksacks(rucksacks);
    }
}