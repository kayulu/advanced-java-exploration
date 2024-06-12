package com.kayulu.streams.assignment;

import java.util.List;

public class Q2_1810 {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Bob", "", 31),
                new Person("Paul", "", 32),
                new Person("John", "", 33)
        );

        double average = persons.stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Avarage age: " + average);
    }
}
