package com.kayulu.streams.assignment;

import java.util.Arrays;
import java.util.List;

public class Q2_1858 {
    public static void main(String[] args) {
        List<AnotherBook> books = Arrays.asList(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );

        List<String> genreList = books.stream()
                .map(AnotherBook::getGenre)
                .toList();
    }
}
