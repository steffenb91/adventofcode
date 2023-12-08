package org.steffenboe.aoc;

record OnePair() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return type instanceof HighCard;
    }
    
}
