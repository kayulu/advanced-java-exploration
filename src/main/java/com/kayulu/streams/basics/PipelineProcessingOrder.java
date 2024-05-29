package com.kayulu.streams.basics;

import java.util.stream.Stream;

public class PipelineProcessingOrder {
    public static void main(String[] args) {
                /*  Each element moves along the chain vertically:
                filter: Alex
                forEach: Alex
                filter: David
                forEach: David
                filter: April
                forEach: April
                filter: Edward
                forEach: Edward     */
        Stream.of("Alex", "David", "April", "Edward")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("foreach: " + s));

        System.out.println("-----------");

        // elements pass through the pipeline one at time
        // if an element is filtered out, or the element has reached a terminal operation,
        // processing of the next element in the stream will begin.
        boolean anyMatch = Stream.of("Kay", "David", "April", "Edward")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> s.startsWith("A"));

        System.out.println("-----------");

        Stream.of("Alex", "David", "Tom", "Edward", "Zack", "April", "Peter")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " +s ));
    }
}
