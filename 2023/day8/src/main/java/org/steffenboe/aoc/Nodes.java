package org.steffenboe.aoc;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

record Nodes(String instructions, Map<String, Node> nodes) {

    public long steps(String start) {
        long steps = 0;
        steps = navigate(start, steps);
        return steps;
    }

    private long navigate(String first, long steps) {
        Node current = nodes.get(first);
        Node next = nodes.get(first);
        Stream<Character> infiniteStream = Stream.iterate(0, i -> (i + 1) % instructions.toCharArray().length)
                .map(i -> instructions.toCharArray()[i]);
        Iterator<Character> iterator = infiniteStream.iterator();
        while (iterator.hasNext()) {
            char instruction = iterator.next();
            System.out.println("Applying instruction " + instruction + " to " + current.id());
            current = next;
            if (next != null && !next.id().equals("ZZZ")) {
                final Node copy = current.copy();
                if (instruction == 'L') {
                    next = nodes.get(copy.left());
                } else {
                    next = nodes.get(copy.right());
                }
                steps++;
            } else {
                return steps;
            }
        }
        return steps;
    }

}
