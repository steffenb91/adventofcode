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
    public void shouldCompile() {
        Node[][] pipes = new Node[5][5];
        pipes[0][0] = new Node('.');
        pipes[0][1] = new Node('.');
        pipes[0][2] = new Node('.');
        pipes[0][3] = new Node('.');
        pipes[0][4] = new Node('.');

        pipes[1][0] = new Node('.');
        pipes[1][1] = new Node('S');
        pipes[1][2] = new Node('-');
        pipes[1][3] = new Node('7');
        pipes[1][4] = new Node('.');

        pipes[2][0] = new Node('.');
        pipes[2][1] = new Node('|');
        pipes[2][2] = new Node('.');
        pipes[2][3] = new Node('|');
        pipes[2][4] = new Node('.');

        pipes[3][0] = new Node('.');
        pipes[3][1] = new Node('L');
        pipes[3][2] = new Node('-');
        pipes[3][3] = new Node('J');
        pipes[3][4] = new Node('.');

        pipes[4][0] = new Node('.');
        pipes[4][1] = new Node('.');
        pipes[4][2] = new Node('.');
        pipes[4][3] = new Node('.');
        pipes[4][4] = new Node('.');

        Grid grid = new Grid(pipes);
        assertThat(grid.furthestAway(), is(4));
    }

    @Test
    void shuoldGetShortestPath() throws IOException {
        Grid grid = new FromTextGridBuilder(Path.of("../resources.input.txt")).buildGrid(12, 13);
        int actual = grid.sumOfShortestPaths();
    }
}
