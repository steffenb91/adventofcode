package org.steffenboe.aoc;

record FourOfAKind() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return !(type instanceof FiveOfAKind);
    }
    
}
