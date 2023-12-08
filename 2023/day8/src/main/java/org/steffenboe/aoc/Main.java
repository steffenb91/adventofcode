package org.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String instructions = "LLRLRRRLRRRLRRLLRRRLLRRLLRLRLRRRLRRRLLRRRLLRRRLRRLRRLRLRRLLRRRLRRRLLRRRLRRLLLRRLRLLLRLRRRLRLRLLLRRLRRLLLRRRLLRRRLRLRLLRRLRLRRRLRLRLLRLRRLRRRLRRLRLRRRLRLRRLRRLRLRRLLRLRLRRLRLLRRLRRLRLRRLLRLRLLRRLLRLLLRRLRLRRRLRRRLRRRLRLRLRRRLLLRLRRLRLRRRLRRRLRRRLRLRRRLRRRLRRRLRRRR";
        Map<String, Node> nodes = new HashMap<>();
        Files.readAllLines(Path.of("input.txt")).forEach(line -> {
            if (line.contains("=")) {
                String id = line.split("=")[0].trim();
                String left = line.split("=")[1].split(",")[0].replace("(", "").trim();
                String right = line.split("=")[1].split(",")[1].replace(")", "").trim();
                if(!nodes.containsKey(id)){
                    nodes.put(id, new Node(id, left, right));
                }
            }
        });
        
        
        Nodes n = new Nodes(instructions, nodes);
        
        System.out.println(n.steps("AAA"));
    }
}