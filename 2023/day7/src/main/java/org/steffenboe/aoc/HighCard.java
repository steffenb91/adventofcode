package org.steffenboe.aoc;

record HighCard() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return false;
    }
    
}
