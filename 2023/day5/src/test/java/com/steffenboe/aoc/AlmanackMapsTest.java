package com.steffenboe.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

class AlmanackMapsTest {

    @Test
    void shouldMapAll() {
        MappingRule seedToSoil1 = new MappingRule(50, 98, 2);
        MappingRule seedToSoil2 = new MappingRule(52, 50, 48);
        MappingRule soilToFertilizer1 = new MappingRule(0, 15, 37);
        MappingRule soilToFertilizer2 = new MappingRule(37, 52, 2);
        MappingRule soilToFertilizer3 = new MappingRule(39, 0, 15);
        AlmanackMap seedToSoil = new AlmanackMap("seed-to-soil");
		seedToSoil.addMappingRule(seedToSoil1);
		seedToSoil.addMappingRule(seedToSoil2);
        AlmanackMap soilToFertilizer = new AlmanackMap("soil-to-fertilizer");
		soilToFertilizer.addMappingRule(soilToFertilizer1);
		soilToFertilizer.addMappingRule(soilToFertilizer2);
		soilToFertilizer.addMappingRule(soilToFertilizer3);
        AlmanackMaps almanackMaps = new AlmanackMaps(List.of(seedToSoil, soilToFertilizer));
        assertThat(almanackMaps.get(79L), is(81L));
    }
}
