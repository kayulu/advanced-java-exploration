package com.kayulu.streams.basics.assignment;

import java.util.Optional;

public class Q2_1849 {
    public static void main(String[] args) {
        // a
        // Optional<Double> price = (value == null) ? Optional.empty() : Optional.of(value)
        Optional<Double> price = Optional.ofNullable(20.0);

        price.ifPresent(System.out::println);
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));

        // b
        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println(price2);
        if(price2.isEmpty())
            System.out.println("empty");
        else System.out.println(price.get());

        price2.ifPresent(System.out::println);

        Double x = price2.orElse(44.0);
        System.out.println(x);

        // c
        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
        System.out.println("value of z: " + z);
    }
}
