package com.adventofcode.core;

import java.util.Objects;

public class Entity {

    private String name;
    private String beats;
    private int score;

    public Entity(String name, String beats, int score) {
        this.name = name;
        this.beats = beats;
        this.score = score;
    }

    /**
     * @return does this entity "beats" the given entity?
     */
    public boolean beats(Entity other) {
        return other.name.equals(beats);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Entity)) {
            return false;
        }
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name) && Objects.equals(beats, entity.beats) && score == entity.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, beats, score);
    }

}
