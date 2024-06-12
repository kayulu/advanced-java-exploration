package com.kayulu.streams.assignment;

import java.util.List;
import java.util.OptionalInt;

public class Q2_1738 {
    public static void main(String[] args) {
        a();
        b();
        c();
    }

    private static void c() {
        List<Integer> integers = List.of(10, 47, 33, 23);

        // i
        integers.stream()
                .reduce(Integer::max)
                .ifPresent(System.out::println);

        // ii
        int max = integers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);

        System.out.println(max);
    }

    private static void b() {
        List<Person> persons = List.of(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        );

        OptionalInt max = persons.stream()
                .map(Person::getAge)
                .mapToInt(Integer::intValue)
                .max();

        max.ifPresent(System.out::println);
    }

    private static void a() {
        List<Integer> integerList = List.of(1, 2, 3);

        // i
        int sum = integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // ii
        OptionalInt max = integerList.stream()
                .mapToInt(Integer::intValue)
                .max();

        max.ifPresent(System.out::println);
    }
}
