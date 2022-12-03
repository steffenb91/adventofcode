package com.adventofcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleReader {
    
    private File file;

    public PuzzleReader(File file) {
        this.file = file;
    }

    public List<Elf> getElves() throws IOException {
        String readString = Files.readString(file.toPath());
        String[] split = readString.split("\\n\\n");
        List<Elf> elves = new ArrayList<>();
        for (String string : split) {
            List<Integer> loads = new ArrayList<>();
            String[] eachLoad = string.split("\\n");
            for (String load : eachLoad) {
                loads.add(Integer.parseInt(load));
            }
            elves.add(new Elf(loads));
        }
        return elves;
    }
}
