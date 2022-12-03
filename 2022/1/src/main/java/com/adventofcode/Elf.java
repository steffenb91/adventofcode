package com.adventofcode;

import java.util.List;

public class Elf {

    private List<Integer> loads;

    public Elf(List<Integer> loads) {
        this.loads = loads;
    }

    public int getCurrentLoad() {
        return loads.stream().mapToInt(x -> x).sum();
    }
    
}
