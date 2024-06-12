package com.kayulu.lambda.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTypes {
    public static void main(String[] args) {
//        boundMethodReference();
//        unboundMethodReference();
//        staticMethodReference();
        constructorMethodReference();
    }

    private static void boundMethodReference() {
        String name = "Mr. kayhan";

        Supplier<String> upperL = () -> name.toUpperCase(); // name is bound to the lambda
        Supplier<String> upperMR = name::toUpperCase;

        Predicate<String> titleL = title -> name.startsWith(title); // title is just passed through to the method (redundancy)
        Predicate<String> titleMR = name::contains;

        System.out.println(titleMR.test("Mr."));
    }

    // Method reference that is not bound to an instance
    private static void unboundMethodReference() {
        Function<String, String> toUpperL = s -> s.toUpperCase();
        Function<String, String> toUpperMR = String::toUpperCase;

        System.out.println(toUpperMR.apply("hello"));

        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;

        System.out.println(concatMR.apply("Kay ", "Ulu"));
    }

    private static void staticMethodReference() {
        Supplier<Double> randomL = () -> Math.random();
        Supplier<Double> randomMR = Math::random;

        System.out.println(randomMR.get());
    }

    private static void constructorMethodReference() {
        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        Supplier<StringBuilder> supplierMR = StringBuilder::new;

        StringBuilder builder = supplierMR.get();

        builder.append("Hello");
        System.out.println(builder);

        Function<Integer, List<String>> function = x -> new ArrayList<>(x);
        Function<Integer, List<String>> functionMR = ArrayList::new;

        List<String> ls1 = function.apply(10);
        ls1.add("Hello");
        List<String> ls2 = functionMR.apply(5);
        ls2.add("World");
    }
}
