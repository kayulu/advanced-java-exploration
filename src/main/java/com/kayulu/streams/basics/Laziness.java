package com.kayulu.streams.basics;

import java.util.Arrays;
import java.util.List;

public class Laziness {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("April", "Ben", "Charlie",
                "David", "Benildus", "Christian");

        names.stream()
                .peek(System.out::println)
                .filter(s -> {
                    System.out.println("filter1: " + s);
                    return s.startsWith("B") || s.startsWith("C");
                })
                .filter(s -> {
                    System.out.println("filter2: " + s);
                    return s.length() > 3;
                })
                .limit(1)   // this is a stateful op; it manages an internal counter
                .forEach(System.out::println);
    }
}
