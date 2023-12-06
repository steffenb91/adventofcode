package com.steffenboe.aoc;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class MappingRule {

    private final long destinationRangeStart;
    private final long sourceRangeStart;
    private final long rangeLength;

    MappingRule(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
        this.destinationRangeStart = destinationRangeStart;
        this.sourceRangeStart = sourceRangeStart;
        this.rangeLength = rangeLength;
    }

    Map<Long, Long> apply(long key) {
        Map<Long, Long> result = new HashMap<>();
        IntStream.range(0, (int) rangeLength).parallel().forEach(i -> {
            if (key == sourceRangeStart + i) {
                result.put(sourceRangeStart + i, destinationRangeStart + i);
            }
        });
        return result;
    }

}