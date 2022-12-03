package com.adventofcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class RucksacksTest {
    
    @Test
    void shouldGetPriorityForAll() {
        Rucksack first = mock(Rucksack.class);
        when(first.getPriorityForCommonItem()).thenReturn(5);
        Rucksack second = mock(Rucksack.class);
        when(second.getPriorityForCommonItem()).thenReturn(5);
        List<Rucksack>  allRucksacks = List.of(first, second);
        Rucksacks rucksacks = new Rucksacks(allRucksacks);
        assertThat(rucksacks.getTotalPriority(), is(10));
    }
}
