package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Grid {

    private Node[][] nodes;

    public Grid(Node[][] pipes) {
        this.nodes = pipes;
    }

    private Node connectPipes() {
        Node startPipe = null;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                Node pipe = nodes[i][j];
                pipe.unvisit();
                if (pipe.isStart()) {
                    startPipe = pipe;
                }
                if (i + 1 < nodes.length) {
                    pipe.addNeighbor(Direction.S, nodes[i + 1][j]);
                }
                if (j + 1 < nodes[0].length) {
                    pipe.addNeighbor(Direction.E, nodes[i][j + 1]);
                }
                if (i - 1 >= 0) {
                    pipe.addNeighbor(Direction.N, nodes[i - 1][j]);
                }
                if (j - 1 >= 0) {
                    pipe.addNeighbor(Direction.W, nodes[i][j - 1]);
                }

            }
        }
        return startPipe;
    }

    int furthestAway() {
        Node startPipe = connectPipes();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startPipe);
        startPipe.visit();
        while (!queue.isEmpty()) {
            countDistance(queue);
        }
        return Arrays.stream(nodes).flatMap(Arrays::stream).mapToInt(Node::getDistanceToStart).max().getAsInt();
    }

    private void countDistance(Queue<Node> queue) {
        Node currentNode = queue.poll();
        for (Connection connection : currentNode.neighbors('.')) {
            Node node = connection.node();
            if (!node.isVisited()) {
                node.visit();
                queue.add(connection.node());
                node.setDistanceToStart(currentNode.getDistanceToStart() + 1);
            }
        }
    }

    int sumOfShortestPaths() {
        connectPipes();
        List<Node> galaxies = getNonEmptyNodes();
        List<Pair> pairs = getPairsOfNodes(galaxies);
        int result = 0;
        for (Pair pair : pairs) {
            connectPipes();
            Node start = pair.first();
            Node target = pair.second();
            Queue<Node> queue = new LinkedList<>();
            queue.add(start);
            start.visit();
            while (!queue.isEmpty()) {
                Node currentPipe = queue.poll();
                if (currentPipe.equals(target)) {
                    int steps = reconstructPath(target);
                    result += steps;
                    break;
                }
                for (Connection connection : currentPipe.neighbors('l')) {
                    Node node = connection.node();
                    if (!node.isVisited()) {
                        node.visit();
                        queue.add(connection.node());
                        node.setParent(currentPipe);
                    }
                }
            }
        }

        return result;

    }

    private List<Pair> getPairsOfNodes(List<Node> galaxies) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                pairs.add(new Pair(galaxies.get(i), galaxies.get(j)));
            }
        }
        return pairs;
    }

    private List<Node> getNonEmptyNodes() {
        List<Node> galaxies = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                if (nodes[i][j].identifier() != '.') {
                    galaxies.add(nodes[i][j]);
                }
            }
        }
        return galaxies;
    }

    private int reconstructPath(Node target) {
        List<Node> path = new ArrayList<>();
        Node current = target;
        while (current.getParent() != null) {
            path.add(current);
            current = current.getParent();
        }
        Collections.reverse(path);
        return path.size();
    }

}
