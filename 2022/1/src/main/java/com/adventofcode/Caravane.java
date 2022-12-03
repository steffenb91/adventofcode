package com.adventofcode;

import java.util.List;
import java.util.stream.Collectors;

public class Caravane {

    private List<Elf> elves;

    public Caravane(List<Elf> elves) {
        this.elves = elves;
    }

    public int getTopLoader() {
        return elves.stream().mapToInt(elf -> elf.getCurrentLoad()).max().getAsInt();
    }

    public int getTopThreeLoaders() {
        int[] loads = elves.stream().mapToInt(elf -> elf.getCurrentLoad()).sorted().toArray();
        int top = loads[loads.length - 1];
        int second = loads[loads.length - 2];
        int third = loads[loads.length - 3];
        return top + second + third;
    }

}
