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

    StrategyGuide read() throws IOException {
        String input = Files.readString(file.toPath());
        List<Round> allRounds = new ArrayList<>();
        
        for (String round : input.split("\\n")) {    
            String[] strategy = round.split(" ");
            RockPaperScissors player1 = RockPaperScissors.fromString(strategy[0]);
            allRounds.add(
                    new Round(player1, 
                                RockPaperScissors.withStrategy(player1, strategy[1])));
        }
        return new StrategyGuide(new Rounds(allRounds));
    }

}
