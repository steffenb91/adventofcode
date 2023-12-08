package org.steffenboe.aoc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

record Nodes(String instructions, Map<String, Node> nodes) {

    public long steps(List<String> start) throws InterruptedException {
        long steps1 = 0;
        // für jede Richtung
        //  neuen Thread pro next Knoten
        //  alle threads speichern ihren current und next knoten ab
        // sind alle Knoten auf Z? 
        //    falls ja, beende und gebe steps zurück
        //    falls nein, beginne neue Richtung
        Stream<Character> infiniteStream = Stream.iterate(0, i -> (i + 1) % instructions.toCharArray().length)
                .map(i -> instructions.toCharArray()[i]);
        Iterator<Character> iterator = infiniteStream.iterator();
        List<String> current = new ArrayList<>(start);
        while (iterator.hasNext()) {
            List<String> next = new ArrayList<>();
            char instruction = iterator.next();
            for (String node : current) {
                List<Thread> threads = new ArrayList<>();
                threads.add(Thread.ofVirtual().start(() -> {
                    Node currentNode = nodes.get(node);
                    if (instruction == 'L') {
                        next.add(currentNode.left());
                    } else {
                        next.add(currentNode.right());
                    }
                }));
                for (Thread thread : threads) {
                    thread.join();
                }

            }
            steps1++;
            current = next;
            if (current.stream().parallel().allMatch(id -> id.endsWith("Z"))) {
                return steps1;
            }
        }

        return steps1;
    }

    private long navigate(List<String> start) {
        long steps = 0;
        // für jede Richtung
        //  neuen Thread pro next Knoten
        //  alle threads speichern ihren current und next knoten ab
        // sind alle Knoten auf Z? 
        //    falls ja, beende und gebe steps zurück
        //    falls nein, beginne neue Richtung
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
