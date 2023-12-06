package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

class Boat {

    private long recordInMillimeter;

    Boat(long recordInMillimeter){
        this.recordInMillimeter = recordInMillimeter;
    }

    int waysToBeatRecord(long raceDuration){
        List<Long> result = new ArrayList<>();
        LongStream.range(0, raceDuration).forEach(rampUpInMillis -> {
            long travelTime = raceDuration - rampUpInMillis;
            long travelDistance = rampUpInMillis * travelTime;
            if (travelDistance > recordInMillimeter){
                result.add(rampUpInMillis);
            }
        });
        return result.size();
    }
}
