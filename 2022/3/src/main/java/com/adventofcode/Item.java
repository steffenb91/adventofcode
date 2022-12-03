package com.adventofcode;

import java.util.Objects;

public class Item {

    private static final int START_FOR_LOWER_CASE = 1;
    private static final int START_FOR_UPPER_CASE = 27;

    private Character itemIdentifier;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public Item(Character itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public int getPriority() {
        if(Character.isLowerCase(itemIdentifier)) {
            return priorityForLowerCase();
        } else {
            return priorityForUpperCase();
        }
    }

    private int priorityForUpperCase() {
        return START_FOR_UPPER_CASE + ALPHABET.toUpperCase().indexOf(itemIdentifier);
    }

    private int priorityForLowerCase() {
        return START_FOR_LOWER_CASE + ALPHABET.indexOf(itemIdentifier);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(itemIdentifier, item.itemIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIdentifier);
    }

    
}
