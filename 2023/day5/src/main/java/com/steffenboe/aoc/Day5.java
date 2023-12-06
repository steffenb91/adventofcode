/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.steffenboe.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author steffenboe
 */
public class Day5 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        List<AlmanackMap> almanackMaps = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            String currentMap;
            AlmanackMap currentAlmanackMap = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("processing... " + line);

                if (line.contains("map:")) {
                    currentMap = line.replace(":", "");
                    currentAlmanackMap = new AlmanackMap(currentMap);
                    almanackMaps.add(currentAlmanackMap);
                }

                if (!line.isBlank() && Character.isDigit(line.charAt(0))) {
                    String[] mappings = line.split(" ");
                    MappingRule rule = new MappingRule(Long.parseLong(mappings[0]), Long.parseLong(mappings[1]),
                            Long.parseLong(mappings[2]));
                    currentAlmanackMap.addMappingRule(rule);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("seeds:")) {
                    String[] seedLine = line.split("seeds: ")[1].split(" ");

                    for (int i = 0; i < seedLine.length; i += 2) {
                        Long seed = Long.parseLong(seedLine[i].strip());
                        Long range = Long.parseLong(seedLine[i + 1].strip());
                        final AlmanackMaps almanackMapping = new AlmanackMaps(almanackMaps);
                        System.out.println(IntStream.range(0, range.intValue()).parallel().mapToLong(j -> {
                            return almanackMapping.get(seed + j);
                        }).min().getAsLong());
                    }
                }
            }
        }
    }
}
