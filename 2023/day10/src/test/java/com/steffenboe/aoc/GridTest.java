package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GridTest {

	@Test
	public void shouldCompile() {
		Pipe[][] pipes = new Pipe[5][5];
		pipes[0][0] = new Pipe('.');
		pipes[0][1] = new Pipe('.');
		pipes[0][2] = new Pipe('.');
		pipes[0][3] = new Pipe('.');
		pipes[0][4] = new Pipe('.');

		pipes[1][0] = new Pipe('.');
		pipes[1][1] = new Pipe('S');
		pipes[1][2] = new Pipe('-');
		pipes[1][3] = new Pipe('7');
		pipes[1][4] = new Pipe('.');

		pipes[2][0] = new Pipe('.');
		pipes[2][1] = new Pipe('|');
		pipes[2][2] = new Pipe('.');
		pipes[2][3] = new Pipe('|');
		pipes[2][4] = new Pipe('.');

		pipes[3][0] = new Pipe('.');
		pipes[3][1] = new Pipe('L');
		pipes[3][2] = new Pipe('-');
		pipes[3][3] = new Pipe('J');
		pipes[3][4] = new Pipe('.');

		pipes[4][0] = new Pipe('.');
		pipes[4][1] = new Pipe('.');
		pipes[4][2] = new Pipe('.');
		pipes[4][3] = new Pipe('.');
		pipes[4][4] = new Pipe('.');

		Grid grid = new Grid(pipes);
		assertThat(grid.furthestAway(), is(4));
	}
}
