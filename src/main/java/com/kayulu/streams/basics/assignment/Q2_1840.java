package com.kayulu.streams.basics.assignment;

import java.util.Arrays;
import java.util.List;

public class Q2_1840 {
    public static void main(String[] args) {
        // a
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        boolean anyMatch = ls.stream()
                .distinct()
                .anyMatch(e -> e == 11);
        System.out.println(anyMatch);

        // b
        boolean noneMatch = ls.stream()
                .noneMatch(x -> x % 11 > 0);
        System.out.println(noneMatch);
    }
}
