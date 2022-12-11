package com.adventofcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.adventofcode.core.Entity;
import com.adventofcode.core.Round;
import com.adventofcode.rockpaperscissors.RockPaperScissorsGame;

@ExtendWith(MockitoExtension.class)
class RoundTest {
	
	@Test
	void shouldLoose() {
		Entity player1 = RockPaperScissorsGame.PAPER.getEntity();
		Entity player2 = RockPaperScissorsGame.ROCK.getEntity();
		Round round = new Round(player1, player2);
		assertThat(round.getScoreForPlayer2(), is(1));
	}

	@Test
	void shouldWin() {
		Entity player1 = RockPaperScissorsGame.SCISSORS.getEntity();
		Entity player2 = RockPaperScissorsGame.ROCK.getEntity();
		Round round = new Round(player1, player2);
		assertThat(round.getScoreForPlayer2(), is(7));
	}

	@Test
	void shouldDraw() {
		Entity player1 = RockPaperScissorsGame.PAPER.getEntity();
		Entity player2 = RockPaperScissorsGame.PAPER.getEntity();
		Round round = new Round(player1, player2);
		assertThat(round.getScoreForPlayer2(), is(5));
	}
}
