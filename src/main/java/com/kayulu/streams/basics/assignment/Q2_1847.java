package com.kayulu.streams.basics.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2_1847 {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        );

        bookList.stream()
                // in case of duplicate key-entry, do something
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, (b1, b2) -> (b1 + b2) / 2))
                .forEach((n, p) -> {
                    System.out.println("book: " + n);
                    System.out.println("price: " + p);
                    System.out.println("-");
                });
    }
}
