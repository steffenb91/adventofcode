package com.steffenboe.aoc;

record Position(int x, int y) {

    Position move(Direction direction) {
        if (direction.equals(Direction.NORTH)) {
            int newX = x - 1;
            if(newX >= 0){
                return new Position(newX, y);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", x, y);
    }

}
