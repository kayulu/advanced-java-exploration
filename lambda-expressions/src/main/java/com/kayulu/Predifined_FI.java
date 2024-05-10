package com.kayulu;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predifined_FI {
    public static void main(String[] args) {
        Predifined_FI pFI = new Predifined_FI();

        pFI.predicate();
    }

    // Note: a Predicate takes one or more arguments and returns a boolean regarding a
    // condition defined by the Predicate on those arguments.
    public void predicate() {
        // a Predicate that takes one argument
        Predicate<String> pStr = str -> str.contains("City");
        System.out.println(pStr.test("New York City"));

        // a Predicate that takes two arguments
        BiPredicate<String, Integer> biPredicate = (str, len) -> str.length() == len;
        System.out.println(biPredicate.test("City Hall", 10));
    }
}
