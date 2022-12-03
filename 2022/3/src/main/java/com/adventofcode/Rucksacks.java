package com.adventofcode;

import java.util.List;

class Rucksacks {

    private List<Rucksack> rucksacks;

    Rucksacks(List<Rucksack> rucksacks) {
        this.rucksacks = rucksacks;
    }

    int getTotalPriority() {
        return rucksacks.stream()
                .mapToInt(rucksack -> rucksack.getPriorityForCommonItem())
                .sum();
    }

    int getTotalPriorityForGroups() {
        int result = 0;
        int groupSize = 3;
        for (int i = 0; i < rucksacks.size(); i += groupSize) {
            result += rucksacks.get(i).getCommonItem(rucksacks.get(i + 1), rucksacks.get(i + 2))
                    .map(item -> item.getPriority()).orElse(0);
        }
        return result;
    }

}
