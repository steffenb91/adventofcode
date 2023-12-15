package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class PlatformTest {

    @Test
    void shouldTilt() throws IOException {
        Platform platform = new Platform(Path.of("input.txt"));
        platform.tiltNorth();
        assertThat(platform.result(), is(136));

    }
}
