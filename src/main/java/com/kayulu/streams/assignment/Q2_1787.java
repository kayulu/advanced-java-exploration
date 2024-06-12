package com.kayulu.streams.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q2_1787 {
    public static void main(String[] args) {
        Stream<List<String>> lists = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));

        lists.filter(list -> list.contains("c"))
                .flatMap(ls -> ls.stream())
                .forEach(System.out::print);
    }
}
