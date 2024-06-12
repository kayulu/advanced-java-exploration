package com.kayulu.streams.assignment;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Q2_2023 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 5);    // 0..4
        OptionalDouble average = intStream.average();
        average.ifPresent(System.out::println);
    }
}
