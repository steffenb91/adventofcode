package com.steffenboe.aoc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Grid {

    private Node[][] pipes;

    public Grid(Node[][] pipes) {
        this.pipes = pipes;
    }

    public Node connectPipes() {
        Node startPipe = null;
        for (int i = 0; i < pipes.length; i++) {
            for (int j = 0; j < pipes.length; j++) {
                System.out.println(i + ", " + j);
                Node pipe = pipes[i][j];
                if (pipe.isStart()) {
                    startPipe = pipe;
                }
                if (i + 1 < pipes.length) {
                    pipe.addNeighbor(Direction.S, pipes[i + 1][j]);
                }
                if (j + 1 < pipes.length) {
                    pipe.addNeighbor(Direction.E, pipes[i][j + 1]);
                }
                if (i - 1 >= 0) {
                    pipe.addNeighbor(Direction.N, pipes[i - 1][j]);
                }
                if (j - 1 >= 0) {
                    pipe.addNeighbor(Direction.W, pipes[i][j - 1]);
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
        int i = 0;
        while (!queue.isEmpty()) {
            i++;
            System.out.println(i);
            Node currentPipe = queue.poll();
            System.out.println("Current pipe: " + currentPipe);
            for (Connection connection : currentPipe.neighbors('.')) {
                Node pipe = connection.pipe();
                if (!pipe.isVisited()) {
                    pipe.visit();
                    queue.add(connection.pipe());
                    pipe.setDistanceToStart(currentPipe.getDistanceToStart() + 1);
                }
            }
        }
        return Arrays.stream(pipes).flatMap(Arrays::stream).mapToInt(Node::getDistanceToStart).max().getAsInt();
    }

    public int sumOfShortestPaths() {
        return 0;
    }

}
