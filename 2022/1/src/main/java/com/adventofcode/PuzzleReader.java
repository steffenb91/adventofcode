package com.adventofcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PuzzleReader {
    
    private File file;

    public PuzzleReader(File file) {
        this.file = file;
    }

    public List<Elf> getElves() throws IOException {
        String puzzle = Files.readString(file.toPath());
        String[] sections = puzzle.split("\\n\\n");
        return getElves(sections);
    }

    private List<Elf> getElves(String[] sections) {
        List<Elf> elves = new ArrayList<>();
        for (String section : sections) {
            elves.add(getElfFromSection(section));
        }
        return elves;
    }

    private Elf getElfFromSection(String section) {
        List<Integer> loads = new ArrayList<>();
        String[] eachLoad = section.split("\\n");
        for (String load : eachLoad) {
            loads.add(Integer.parseInt(load));
        }
        return new Elf(loads);
    }
}
