package com.adventofcode;

import java.io.File;
import java.io.IOException;

import com.adventofcode.core.Rounds;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StrategyGuideReader strategyGuideReader = new StrategyGuideReader(new File(args[0]));
        try {
            Rounds rounds = strategyGuideReader.read();
            System.out.println(rounds.getTotalScore());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
