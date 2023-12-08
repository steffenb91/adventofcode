/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steffenboe
 */
public class Day7 {

    public static void main(String[] args) throws IOException {
        List<Hand> hands = new ArrayList<>();
        Files.readAllLines(Path.of("input.txt")).forEach(line -> {
            String[] split = line.split(" ");
            hands.add(new Hand(new Cards(split[0]), Integer.parseInt(split[1])));
        });
        System.out.println(new CamelCards(hands).totalWinning());
    }
}
