package org.steffenboe.aoc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

class Hand implements Comparable<Hand>{
 
    private Cards cards;
    private int bid;

    Hand(Cards cards, int bid){
        this.cards = cards;
        this.bid = bid;
    }

    @Override
    public int compareTo(Hand other) {
        if(this.equals(other)){
            return 0;
        }
        if(type().equals(other.type())){
            return cards.compareTo(other.cards);
        }
        if(type().isStrongerThan(other.type())){
            return 1;
        } else {
            return -1;
        } 
        
    }

    private Type type() {
        return cards.type();
    }

    int bid() {
        return bid;
    }

    @Override
    public String toString() {
        return cards.toString();
    }




}
