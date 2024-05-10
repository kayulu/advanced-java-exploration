package com.kayulu;

import java.time.LocalTime;
import java.util.function.BiPredicate;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Predifined_FI {
    public static void main(String[] args) {
        Predifined_FI pFI = new Predifined_FI();

//        pFI.predicate();
        pFI.supplier();
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

    // Note: A Supplier, as the name suggest takes no args and returns a value
    public void supplier() {
        Supplier<String> strSupplier = () -> "Kayhan";

        Supplier<StringBuilder> strBuilder = StringBuilder::new;
        System.out.println("StringBuilder: " + strBuilder.get().append(strSupplier.get())); // supplier provides

        Supplier<LocalTime> timeSupplier = LocalTime::now;
        System.out.println("Current time: " + timeSupplier.get());

        DoubleSupplier doubleSupplier = Math::random;
        System.out.println("Double Supplier: " + doubleSupplier.getAsDouble());
    }
}
