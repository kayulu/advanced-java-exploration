package com.kayulu;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Predifined_FI {
    public static void main(String[] args) {
        Predifined_FI pFI = new Predifined_FI();

//        pFI.predicate();
//        pFI.supplier();
//        pFI.consumer();
//        pFI.function();
        pFI.operator();
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

    // Note: a consumer, as the name suggests takes an argument and does not return a value
    public void consumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello Consumer");

        // BiConsumer<T, U> takes in two args
        BiConsumer<List<String>, String> biConsumer = (l, s) -> l.add(s.toUpperCase());
        List<String> names = new ArrayList<>();

        biConsumer.accept(names, "kayhan");
        biConsumer.accept(names, "serap");
        biConsumer.accept(names, "selma");

        names.forEach(System.out::println);
    }

    // Note: a Function simply takes an argument and returns a value
    public void function() {
        // Function<T, R>
        Function<String, Integer> fn1 = String::length;
        System.out.println(fn1.apply("Kayhan"));

        // Function<T, U, R>
        BiFunction<String, String, Integer> fn2 = (s1, s2) -> s1.length() + s2.length();
        System.out.println(fn2.apply("Kayhan", "Uludemirciler"));

        BiFunction<String, String, String> fn3 = String::concat;
        System.out.println(fn3.apply("William ", "Shakespear"));
    }

    // Note an Operator takes a value and returns a value of the same type
    public void operator() {
        // UnaryOperator<T, T> extends Function<T, T>
        UnaryOperator<Integer> unaryOperator = v -> v + 1;
        System.out.println(unaryOperator.apply(1));

        // BinaryOperator<T> extends BiFunction<T, T, T>
        BinaryOperator<String> binaryOperator = String::concat; // (s1, s2) -> s1.concat(s2)
        System.out.println(binaryOperator.apply("Kay ", "Ulu"));
    }
}
