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

import com.adventofcode.core.Round;
import com.adventofcode.core.Rounds;

import org.mockito.Mock;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RoundsTest {
	
	@Test
	public void shouldCompile() {
		Round round1 = mock(Round.class);
		when(round1.getScoreForPlayer2()).thenReturn(7);
		Round round2 = mock(Round.class);
		when(round2.getScoreForPlayer2()).thenReturn(3);
		Round round3 = mock(Round.class);
		when(round3.getScoreForPlayer2()).thenReturn(5);
		List<Round> rounds = List.of(round1, round2, round3);
		assertThat(new Rounds(rounds).getTotalScore(), is(15));
	}
}
