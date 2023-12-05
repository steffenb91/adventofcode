package com.steffenboe.aoc;

import java.util.List;

class AlmanackMaps {

    private final List<AlmanackMap> almanackMaps;

    AlmanackMaps(List<AlmanackMap> almanackMaps) {
        this.almanackMaps = almanackMaps;
    }

    long get(Long seed){
        long result = seed;
        for (AlmanackMap map : almanackMaps) {
            result = map.get(result);
        }
        return result;
    }

   
}
