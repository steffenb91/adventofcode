package org.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class HashTest {

    @Test
    void shouldHashString() throws IOException {
        String string = Files.readString(Path.of("input.txt"));
        int totalResult = 0;
        for (String subString : string.split(",")) {
            int result = 0;
            for (Character character : subString.toCharArray()) {
                int res = (int) character;
                result += res;
                result = result * 17;
                result = result % 256;
            }
            totalResult += result;
        }
        assertThat(totalResult, is(1320));
    }
}
