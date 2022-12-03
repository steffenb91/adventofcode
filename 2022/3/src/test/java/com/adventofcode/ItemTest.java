package com.adventofcode;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class ItemTest {

	private Item item;

	@Test
	void shouldGetPriorityForLowerCase() {
		Item item = new Item('a');
		assertThat(item.getPriority(), is(1));
	}

	@Test
	void shouldGetPriorityForUpperCaseA() {
		Item item = new Item('A');
		assertThat(item.getPriority(), is(27));
	}

	@Test
	void shouldGetPriorityForUpperCaseZ() {
		Item item = new Item('Z');
		assertThat(item.getPriority(), is(52));
	}
}
