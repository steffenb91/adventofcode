package com.adventofcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CaravaneTest {

	@Test
	public void shouldCompile() {
		Elf firstElf = mock(Elf.class);
		when(firstElf.getCurrentLoad()).thenReturn(2837);
		Elf secondElf = mock(Elf.class);
		when(secondElf.getCurrentLoad()).thenReturn(9874);
		Caravane caravane = new Caravane(List.of(firstElf, secondElf));
		assertThat(caravane.getTopLoader(), is(9874));
	}

	@Test
	public void shouldGetTopThree() {
		Elf firstElf = mock(Elf.class);
		when(firstElf.getCurrentLoad()).thenReturn(1);
		Elf secondElf = mock(Elf.class);
		when(secondElf.getCurrentLoad()).thenReturn(2);
		Elf thirdElf = mock(Elf.class);
		when(thirdElf.getCurrentLoad()).thenReturn(3);
		Elf fourthElf = mock(Elf.class);
		when(fourthElf.getCurrentLoad()).thenReturn(4);
		Caravane caravane = new Caravane(List.of(firstElf, secondElf, thirdElf, fourthElf));
		assertThat(caravane.getTopThreeLoaders(), is(9));
	}
}
