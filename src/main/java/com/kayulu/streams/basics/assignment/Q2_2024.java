package com.kayulu.streams.basics.assignment;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q2_2024 {
    public static void main(String[] args) {
        // a
        DoubleStream doubleStream = DoubleStream.of(0, 2, 4);
        double sum = doubleStream.filter(d -> d % 2 != 0)
                .sum();
        System.out.println(sum);

        // b
        Stream<Double> doubleStream2 = Stream.of(1.0, 3.0);
        doubleStream2.mapToDouble(Double::doubleValue)
                .filter(d -> d % 2 == 0)
                .average().ifPresent(System.out::println);
    }
}
