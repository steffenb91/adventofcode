package org.steffenboe.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Cards implements Comparable<Cards>{

    private List<Card> all;

    Cards(List<Card> all) {
        this.all = all;
    }

    Cards(String asChars){
        this.all = parseCards(asChars);
    }

    private List<Card> parseCards(String cardsLabels) {
        List<Card> result = new ArrayList<>();
        for(char cardLabel : cardsLabels.toCharArray()){
            result.add(new Card(CardLabel.of(cardLabel)));
        }
        return result;
    }

    Type type() {
        if (sameOfAKind(5) || sameOfAKind(4) && containsJoker(1)) {
            return new FiveOfAKind();
        }
        if (sameOfAKind(4) || sameOfAKind(3) && containsJoker(1)) {
            return new FourOfAKind();
        }
        if (sameOfAKind(3) && hasPairs(1) || sameOfAKind(3) && containsJoker(2) || sameOfAKind(2) && containsJoker(3)) {
            return new FullHouse();
        }
        if (sameOfAKind(3) || sameOfAKind(2) && containsJoker(1)) {
            return new ThreeOfAKind();
        }
        if (hasPairs(2) || hasPairs(1) && containsJoker(2)) {
            return new TwoPairs();
        }
        if(hasPairs(1) || sameOfAKind(1) && containsJoker(1)){
            return new OnePair();
        }

        return new HighCard();
    }

    private boolean containsJoker(int i) {
        return all.stream().filter(card -> card.label().equals(CardLabel.J)).count() == i;
    }

    private boolean hasPairs(long n) {
        Map<Card, Integer> result = new HashMap<>();
        all.stream().forEach(card -> {
            if (result.containsKey(card)) {
                result.put(card, result.get(card) + 1);
            } else {
                result.put(card, 1);
            }
        });
        return result.keySet().stream().filter(entry -> result.get(entry) == 2).count() == n;
    }

    private boolean sameOfAKind(int n) {
        return all.stream()
                .distinct()
                .map(element -> all.stream().filter(e -> e.equals(element)).count())
                .filter(elementCount -> elementCount == n)
                .count() > 0;
    }

    @Override
    public int compareTo(Cards other) {
        if(all.equals(other.all)){
            return 0;
        }
        for (int i = 0; i < all.size(); i++) {
            int result = all.get(i).label().compareRank(other.all.get(i).label());
            if(result != 0){
                return result;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return all.stream().map(card -> card.label().asString()).collect(Collectors.joining());
    }


}
