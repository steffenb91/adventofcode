/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.steffenboe.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steffenboe
 */
public class Day5 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            List<Long> seeds = new ArrayList<>();
            List<AlmanackMap> almanackMaps = new ArrayList<>();
            String currentMap;
            AlmanackMap currentAlmanackMap = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("processing... " + line);

                if (line.startsWith("seeds:")) {
                    String[] seedLine = line.split("seeds: ")[1].split(" ");
                    for (int i = 0; i < seedLine.length; i++) {
                        seeds.add(Long.valueOf(seedLine[i].strip()));
                    }
                }
                if (line.contains("map:")) {
                    currentMap = line.replace(":", "");
                    currentAlmanackMap = new AlmanackMap(currentMap);
                    almanackMaps.add(currentAlmanackMap);
                }

                if (!line.isBlank() && Character.isDigit(line.charAt(0))) {
                    String[] mappings = line.split(" ");
                    MappingRule rule = new MappingRule(Long.parseLong(mappings[0]), Long.parseLong(mappings[1]), Long.parseLong(mappings[2]));
                    currentAlmanackMap.addMappingRule(rule);
                }

            }
            AlmanackMaps finalMaps = new AlmanackMaps(almanackMaps);
            List<Long> result = new ArrayList<>();
            for (Long seed : seeds) {
                result.add(finalMaps.get(seed));
            }
            System.out.println(result.stream().mapToLong(x -> x).min().getAsLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
