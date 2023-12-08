package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.jupiter.api.Test;

class NodesTest {

    @Test
    void shouldMapToZZZ() {
        Node node = new Node("AAA", "BBB", "CCC");
        Node node2 = new Node("BBB", "DDD", "EEE");
        Node node3 = new Node("CCC", "ZZZ", "GGG");
        Node node4 = new Node("ZZZ", "ZZZ", "ZZZ");
        Nodes nodes = new Nodes("RL", Map.of("AAA", node, "BBB", node2, "CCC", node3, "ZZZ", node4));
        assertThat(nodes.steps("AAA"), is(2L));
    }

    @Test
    void shouldRepeatedlyFollowInstructions() {
        Node node = new Node("AAA", "BBB", "BBB");
        Node node2 = new Node("BBB", "AAA", "ZZZ");
        Node node3 = new Node("ZZZ", "ZZZ", "ZZZ");
        Nodes nodes = new Nodes("LLR", Map.of("AAA", node, "BBB", node2, "ZZZ", node3));
        assertThat(nodes.steps("AAA"), is(6L));
    }
}
