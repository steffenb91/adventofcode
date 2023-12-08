package org.steffenboe.aoc;

record FiveOfAKind() implements Type {

    @Override
    public boolean isStrongerThan(Type type) {
        return true;
    }
    
}
