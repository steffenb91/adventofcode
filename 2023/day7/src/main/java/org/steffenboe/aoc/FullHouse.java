package org.steffenboe.aoc;

record FullHouse() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return !(type instanceof FourOfAKind) && !(type instanceof FiveOfAKind);
    }
    
}
