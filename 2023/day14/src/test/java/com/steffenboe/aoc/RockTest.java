package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class RockTest {

    /**
     * If a rock moves, it moves its neighbors.
     */
    @Test
    void shouldMoveNeighbors() {
        Platform platform = new Platform();
        Rock rock1 = new Rock(new Position(0, 5));
        platform.addRock(rock1);
        Rock rock2 = new Rock(new Position(0, 6));
        platform.addRock(rock2);

        rock2.moveNorth();

        assertThat(rock1.position(), is(new Position(0, 4)));
        assertThat(rock2.position(), is(new Position(0, 5)));
    }

    @Test
    void shouldNotMoveIfStationary() {
        Platform platform = new Platform();
        Rock rock1 = new Rock(new Position(1, 5), true);
        platform.addRock(rock1);
        Rock rock2 = new Rock(new Position(2, 5));
        platform.addRock(rock2);
        Rock rock3 = new Rock(new Position(0, 5), true);
        platform.addRock(rock3);
        
        assertThat(rock2.moveNorth(), is(false));

        assertThat(rock1.position(), is(new Position(1, 5)));
        assertThat(rock2.position(), is(new Position(2, 5)));
    }
}
