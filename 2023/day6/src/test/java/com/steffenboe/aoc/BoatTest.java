package com.steffenboe.aoc;

import org.junit.jupiter.api.Test;

class BoatTest {

    @Test
    void shouldSpeedUp() {
        Boat boat = new Boat(219101213651089L);
        System.out.println(boat.waysToBeatRecord(40817772L));
    }
}
