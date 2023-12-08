package org.steffenboe.aoc;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

class NodesTest {

    @Test
    void shouldMapToZZZ() throws InterruptedException {
        Node node = new Node("AAA", "BBB", "CCC");
        Node node2 = new Node("BBB", "DDD", "EEE");
        Node node3 = new Node("CCC", "ZZZ", "GGG");
        Node node4 = new Node("ZZZ", "ZZZ", "ZZZ");
        Nodes nodes = new Nodes("RL", Map.of("AAA", node, "BBB", node2, "CCC", node3, "ZZZ", node4));
        assertThat(nodes.steps(List.of("AAA")), is(2L));
    }

    @Test
    void shouldRepeatedlyFollowInstructions() throws InterruptedException {
        Node node = new Node("AAA", "BBB", "BBB");
        Node node2 = new Node("BBB", "AAA", "ZZZ");
        Node node3 = new Node("ZZZ", "ZZZ", "ZZZ");
        Nodes nodes = new Nodes("LLR", Map.of("AAA", node, "BBB", node2, "ZZZ", node3));
        assertThat(nodes.steps(List.of("AAA")), is(6L));
    }
}
