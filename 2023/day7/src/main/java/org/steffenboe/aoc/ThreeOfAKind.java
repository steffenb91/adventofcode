package org.steffenboe.aoc;

record ThreeOfAKind() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return type instanceof TwoPairs || type instanceof OnePair || type instanceof HighCard;
    }
    
}
