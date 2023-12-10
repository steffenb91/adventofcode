package com.steffenboe.aoc;

record Number(int value) {

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}