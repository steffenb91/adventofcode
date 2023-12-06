package com.steffenboe.aoc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

class MappingRuleTest {

	@Test
	void shouldMapValues() {
		MappingRule mappingRule = new MappingRule(50, 98, 2);
		Map<Long, Long> actual = mappingRule.apply(98L);
		assertThat(actual.get(98L), is(50L));
	}

}
