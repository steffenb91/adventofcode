package org.steffenboe.aoc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

record Nodes(String instructions, Map<String, Node> nodes) {

    /**
     * from reddit: Part 2 you have to be a bit clever since you can't simulate everything as it
     * will take too long. The trick is to simulate each start independently until
     * it first hits a node ending in "Z", then take the LCM of all the steps. It
     * assumes each start hits a target node in a cyclic manner, which seems to be
     * true.
     */
    public BigInteger steps(List<String> start) throws InterruptedException {
        Map<String, BigInteger> stepsForEachNode = new HashMap<>();
        for (String node : start) {
            BigInteger steps1 = new BigInteger("0");
            Stream<Character> infiniteStream = Stream.iterate(0, i -> (i + 1) % instructions.toCharArray().length)
                    .map(i -> instructions.toCharArray()[i]);
            Iterator<Character> iterator = infiniteStream.iterator();
            String next = node;
            while (iterator.hasNext()) {
                char instruction = iterator.next();

                Node currentNode = nodes.get(next);
                if (instruction == 'L') {
                    next = currentNode.left();
                } else {
                    next = currentNode.right();
                }
                steps1 = steps1.add(new BigInteger("1"));
                if (next.endsWith("Z")) {
                    System.out.println("Found end for " + node + ": " + next);
                    stepsForEachNode.put(node, steps1);
                    break;
                }
            }
        }

        // lcm calculation
        return stepsForEachNode.values().stream()
                .reduce(BigInteger.ONE, (a, b) -> a.multiply(b).divide(a.gcd(b)));

    }

    private long navigate(List<String> start) {
        long steps = 0;
        // für jede Richtung
        // neuen Thread pro next Knoten
        // alle threads speichern ihren current und next knoten ab
        // sind alle Knoten auf Z?
        // falls ja, beende und gebe steps zurück
        // falls nein, beginne neue Richtung
        Stream<Character> infiniteStream = Stream.iterate(0, i -> (i + 1) % instructions.toCharArray().length)
                .map(i -> instructions.toCharArray()[i]);
        Iterator<Character> iterator = infiniteStream.iterator();
        List<String> current = new ArrayList<>(start);
        while (iterator.hasNext()) {
            List<String> next = new ArrayList<>();
            char instruction = iterator.next();
            for (String node : current) {
                Node currentNode = nodes.get(node);
                if (instruction == 'L') {
                    next.add(currentNode.left());
                } else {
                    next.add(currentNode.right());
                }
            }
            steps++;
            current = next;
            if (current.stream().allMatch(id -> id.endsWith("Z"))) {
                return steps;
            }
        }

        return steps;

    }

}
