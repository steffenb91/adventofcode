package com.adventofcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.adventofcode.core.Entity;
import com.adventofcode.core.Round;
import com.adventofcode.core.Rounds;
import com.adventofcode.rockpaperscissors.RockPaperScissorsGame;
import com.adventofcode.rockpaperscissors.Strategy;

class StrategyGuideReader {

    private File file;

    StrategyGuideReader(File file) {
        this.file = file;
    }

    Rounds read() throws IOException {
        String input = Files.readString(file.toPath());
        return new Rounds(parseLinesToRounds(input));
    }

    private List<Round> parseLinesToRounds(String input) {
        List<Round> allRounds = new ArrayList<>();
        for (String line : input.split("\\n")) {
            allRounds.add(getRoundFromLine(line));
        }
        return allRounds;
    }

    private Round getRoundFromLine(String round) {
        String[] match = round.split(" ");
        Entity player1Choice = RockPaperScissorsGame.fromString(match[0]);
        Entity player2Choice = Strategy.fromString(match[1]).getEntity(player1Choice);
        return new Round(player1Choice, player2Choice);
    }

}
