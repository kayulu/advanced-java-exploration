package com.kayulu.streams.assignment;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Q2_1841 {
    public static void main(String[] args) {
        // a
        // ai is 0 because the stream has no terminal operation; that means that the stream pipeline is never executed
        // Streams in Java are lazy, so intermediate operations like .filter() are only executed when a terminal operation is present.
        AtomicInteger ai1 = new AtomicInteger();
        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    ai1.incrementAndGet();
                    return n % 2 == 0;
                });
        System.out.println(ai1);

        // b
        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
        stream.filter(e -> {
            ai.incrementAndGet();
            return e % 2 == 0;
        }).forEach(System.out::println);
        System.out.println(ai);
    }
}
