package com.steffenboe.aoc;

record Position(int x, int y) {

    Position move(Direction direction) {
        if (direction.equals(Direction.NORTH)) {
            return new Position(x, y - 1);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", x, y);
    }

}
