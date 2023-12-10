package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class PipeTest {

	@Test
	void shouldIgnoreIfNoConnection() {
		Pipe first = new Pipe('|');
		first.addNeighbor(Direction.E, new Pipe('-'));
		assertThat(first.neighbors().size(), is(0));
	}

	@Test
	void shouldAddConnections() {
		Pipe first = new Pipe('|');
		first.addNeighbor(Direction.N, new Pipe('-'));
		first.addNeighbor(Direction.S, new Pipe('J'));
		assertThat(first.neighbors().size(), is(2));
	}

}
