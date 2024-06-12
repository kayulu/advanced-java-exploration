package com.kayulu.streams.assignment;

import java.util.ArrayList;
import java.util.List;

public class Q2_1762 {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Screw"));
        items.add(new Item(2, "Nail"));
        items.add(new Item(3, "Bolt"));

        items.stream()
                .map(Item::getName)
                .sorted(String::compareTo)
                .forEach(System.out::print);
    }
}
