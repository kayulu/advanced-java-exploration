package com.kayulu.streams.basics.assignment;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2_1846 {

    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        );

        Map<String, Double> bookMap =
                bookList.stream()
                        .collect(
                                Collectors.toMap(
                                        Book::getTitle,
                                        Book::getPrice));

        bookMap.forEach((n, p) -> {
            if (n.startsWith("A"))
                System.out.println(p);
        });
    }
}
