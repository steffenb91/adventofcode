package com.adventofcode;

import java.io.File;
import java.io.IOException;

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
            StrategyGuide strategyGuide = strategyGuideReader.read();
            System.out.println(strategyGuide.getTotalScore());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
