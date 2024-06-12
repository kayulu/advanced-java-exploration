package com.kayulu.streams.assignment;

import java.util.Arrays;
import java.util.List;

public class Q2_1809 {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        books.stream()
                //                .filter(p -> p > 90)
                .filter(p -> p.getPrice() > 10)
                .mapToDouble(Book::getPrice)
                .average()
                .ifPresent(System.out::println);
    }
}
