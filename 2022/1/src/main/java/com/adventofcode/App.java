package com.adventofcode;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int topLoad = 0;
        int loadCarriedByTopThree = 0;
        PuzzleReader puzzleReader = new PuzzleReader(new File(args[0]));
        try {
            List<Elf> elves = puzzleReader.getElves();
            Caravane caravane = new Caravane(elves);
            topLoad = caravane.getTopLoader();
            loadCarriedByTopThree = caravane.getTopThreeLoaders();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Top load: " + topLoad);
        System.out.println("Load carried by top three: " + loadCarriedByTopThree);
    }
}
