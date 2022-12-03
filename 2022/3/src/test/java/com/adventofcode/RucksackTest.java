package com.adventofcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class RucksackTest {
	
	@Test
	void shouldGetPriorityForCommonItem() {
		Rucksack rucksack = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
		assertThat(rucksack.getPriorityForCommonItem(), is(16));
	}
}
