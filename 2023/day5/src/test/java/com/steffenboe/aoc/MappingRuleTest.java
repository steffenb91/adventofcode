package com.steffenboe.aoc;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

class MappingRuleTest {

	@Test
	void shouldMapValues() {
		MappingRule mappingRule = new MappingRule(50, 98, 2);
		Map<Long, Long> actual = mappingRule.apply();
		assertThat(actual.get(98), is(50));
		assertThat(actual.get(99), is(51));
	}

}
