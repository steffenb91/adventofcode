package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GridTest {


    @Test
    void shuoldGetShortestPath() throws IOException {
        Grid grid = new FromTextGridBuilder(Path.of("inputday11.txt")).buildGrid(89, 153);
        int second = grid.sumOfShortestPaths();
        assertThat(second, is(374));
    }
}
