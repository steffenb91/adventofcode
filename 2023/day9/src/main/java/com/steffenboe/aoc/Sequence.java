package com.steffenboe.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Sequence {

    private List<Number> numbers;

    Sequence(List<Number> numbers) {
        this.numbers = numbers;
    }

    List<Sequence> generateChildSequence() {
        List<Number> childNumbers = new ArrayList<>();
        if (numbers.stream().map(Number::value).allMatch(val -> val == 0)) {
            return List.of(new Sequence(childNumbers));
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            Number first = numbers.get(i);
            Number second = numbers.get(i + 1);
            childNumbers.add(new Number(second.value() - first.value()));
        }
        List<Sequence> result = new ArrayList<>();
        Sequence childSequence = new Sequence(childNumbers);
        result.add(childSequence);
        result.addAll(childSequence.generateChildSequence());
        result.add(0, this);
        return result;
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 == this) {
            return true;
        }
        Sequence other = (Sequence) arg0;
        if (Objects.equals(this.numbers, other.numbers)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.stream().map(Number::toString).collect(Collectors.joining(", "));
    }

    public void add(int i) {
        numbers.add(new Number(i));
    }

    public int last() {
        if(numbers.size() == 0){
            return 0;
        }
        return numbers.get(numbers.size() - 1).value();
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

}
