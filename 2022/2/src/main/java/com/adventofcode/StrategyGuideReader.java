package com.adventofcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class StrategyGuideReader {

    private File file;

    StrategyGuideReader(File file) {
        this.file = file;
    }

    Rounds read() throws IOException {
        String input = Files.readString(file.toPath());
        List<Round> allRounds = new ArrayList<>();

        for (String round : input.split("\\n")) {
            allRounds.add(getRoundFromStrategyGuide(round));
        }

        return new Rounds(allRounds);
    }

    private Round getRoundFromStrategyGuide(String round) {
        String[] match = round.split(" ");
        RockPaperScissors player1Choice = RockPaperScissors.fromString(match[0]);
        RockPaperScissors player2Choice = RockPaperScissors.withStrategy(player1Choice, match[1]);
        return new Round(player1Choice, player2Choice);
    }

}
