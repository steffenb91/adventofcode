package com.steffenboe.aoc;

import java.util.HashMap;
import java.util.Map;

class MappingRule {

    private final long destinationRangeStart;
    private final long sourceRangeStart;
    private final long rangeLength;

    MappingRule(long destinationRangeStart, long sourceRangeStart, long rangeLength){
        this.destinationRangeStart = destinationRangeStart;
        this.sourceRangeStart = sourceRangeStart;
        this.rangeLength = rangeLength;
    }

    Map<Long, Long> apply() {
        Map<Long, Long> result = new HashMap<>();
        for (int i = 0; i < rangeLength; i++) {
            result.put(sourceRangeStart + i, destinationRangeStart + i);
        }
        return result;
    }


}