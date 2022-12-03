package com.adventofcode;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class Rucksack {

    private Set<Item> firstCompartment = new HashSet<>();
    private Set<Item> secondCompartment = new HashSet<>();
    private String items;

    Rucksack(String items) {
        this.items = items;
        int middle = items.length() / 2;
        String firstCompartmentItems = items.substring(0, middle);
        String secondCompartmentItems = items.substring(middle, items.length());
        fillRucksack(firstCompartment, firstCompartmentItems);
        fillRucksack(secondCompartment, secondCompartmentItems);
    }

    private void fillRucksack(Set<Item> compartment, String firstCompartmentItems) {
        for (Character item : firstCompartmentItems.toCharArray()) {
            compartment.add(new Item(item));
        }
    }

    public int getPriorityForCommonItem() {
        Optional<Item> common = firstCompartment.stream()
                .filter(item -> secondCompartment.contains(item))
                .findFirst();
        return common.map(item -> item.getPriority()).orElse(0);
    }

    public Optional<Item> getCommonItem(Rucksack second, Rucksack third) {
        for (Character character : items.toCharArray()) {
            if (isCommonItem(second, third, character)) {
                return Optional.of(new Item(character));
            }
        }
        return Optional.empty();
    }

    private boolean isCommonItem(Rucksack second, Rucksack third, Character character) {
        return second.items.contains(asString(character)) 
                && third.items.contains(asString(character));
    }

    private String asString(Character character) {
        return String.valueOf(character);
    }

}
