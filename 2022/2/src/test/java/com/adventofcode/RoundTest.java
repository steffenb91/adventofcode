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
public class RoundTest {
	
	@Test
	public void shouldLoose() {
		Round round = new Round(RockPaperScissors.PAPER, RockPaperScissors.ROCK);
		assertThat(round.getScoreForPlayer2(), is(1));
	}

	@Test
	public void shouldWin() {
		Round round = new Round(RockPaperScissors.SCISSORS, RockPaperScissors.ROCK);
		assertThat(round.getScoreForPlayer2(), is(7));
	}

	@Test
	public void shouldDraw() {
		Round round = new Round(RockPaperScissors.PAPER, RockPaperScissors.PAPER);
		assertThat(round.getScoreForPlayer2(), is(5));
	}
}
