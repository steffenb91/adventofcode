package com.adventofcode;

import java.io.File;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        PuzzleReader puzzleReader = new PuzzleReader(new File(args[0]));
        try {
            Rucksacks rucksacks = puzzleReader.readPuzzle();
            System.out.println(rucksacks.getTotalPriority());
            System.out.println(rucksacks.getTotalPriorityForGroups());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
