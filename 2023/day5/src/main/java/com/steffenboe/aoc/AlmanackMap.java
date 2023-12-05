package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AlmanackMap {

    private final String mapIdentifier;
    private final Map<Long, Long> map;
    private List<MappingRule> mappingRules = new ArrayList<>();

    AlmanackMap(String mapIdentifier) {
        this.mapIdentifier = mapIdentifier;
        this.map = new HashMap<>();
    }

    void putAll(Map<Long, Long> values) {
        map.putAll(values);
    }

    Long get(Long key) {
        Map<Long, Long> result = new HashMap<>();
        for (MappingRule mappingRule : mappingRules) {
            result.putAll(mappingRule.apply());
        }
        if (result.containsKey(key)) {
            return result.get(key);
        } else {
            return key;
        }
    }

    String getMapIdentifier() {
        return mapIdentifier;
    }

    public void addMappingRule(MappingRule mappingRule) {
        this.mappingRules.add(mappingRule);
    }



}
