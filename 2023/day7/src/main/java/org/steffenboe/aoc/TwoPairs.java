package org.steffenboe.aoc;

record TwoPairs() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return type instanceof OnePair || type instanceof HighCard;
    }
    
}
