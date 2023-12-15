package com.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class Platform {

    private List<Rock> rocks = new ArrayList<>();
    private int width = 0;
    private int height = 0;

    Platform() {
    }

    Platform(Path input) throws IOException {
        List<String> lines = Files.readAllLines(input);
        this.height = lines.size();
        for (int i = 0; i < height; i++) {
            System.out.println("Reading line " + i + ": " + lines.get(i));
            char[] allChars = lines.get(i).toCharArray();
            this.width = allChars.length;
            for (int j = 0; j < width; j++) {
                if ('O' == allChars[j]) {
                    System.out.println("Added new 0 rock at " + i + ", " + j);
                    addRock(new Rock(new Position(i, j)));
                }
                if ('#' == allChars[j]) {
                    System.out.println("Added new # rock at " + i + ", " + j);
                    addRock(new Rock(new Position(i, j), true));
                }
            }
        }
    }

    void addRock(Rock newRock) {
        rocks.add(newRock);
        Optional<Rock> neighbor = rocks.stream()
                .filter(rock -> rock.position().equals(newRock.position().move(Direction.NORTH))
                        && !rock.equals(newRock))
                .findFirst();
        if (neighbor.isPresent()) {
            newRock.updateNeighbour(Direction.NORTH, neighbor.get());
        }
    }

    void tiltNorth() {
        boolean stoneMoved = true;
        while (stoneMoved) {
            System.out.println("---------------------------------");
            write();
            stoneMoved = false;
            for (Rock rock : rocks.stream().filter(r -> !r.isStationary()).toList()) {
                if (rock.moveNorth()) {
                    stoneMoved = true;
                }
                System.out.println("---------------------------------");
                write();
                System.out.println("---------------------------------");
            }
        }
    }

    int result() {
        int result = 0;
        for (int i = height; i > 0; i--) {
            int l = i;
            long count = rocks.stream()
                    .filter(rock -> rock.position().x() == (l - 1) && !rock.isStationary())
                    .count();
            result += count * i;
        }
        return result;
    }

    void write() {
        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                int l = i;
                int k = j;
                Optional<Rock> rock = rocks.stream().filter(r -> r.position().equals(new Position(l, k))).findFirst();
                if (rock.isPresent()) {
                    if (rock.get().isStationary()) {
                        sb.append("#");
                    } else {
                        sb.append("O");
                    }
                } else {
                    sb.append(".");
                }
            }
            System.out.println(sb.toString());
        }
    }

}
