package com.kayulu.assignment_2;

import java.util.*;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }

    // 1
    private static void staticMR() {
        System.out.println("--- 1 ---");
        // a
        List<Integer> integerList = Arrays.asList(1, 2, 7, 4, 5);

        // b
        Consumer<List<Integer>> consumerLam = l -> Collections.sort(l);

        // c
        consumerLam.accept(integerList);

        // d
        integerList.forEach(System.out::println);

        // e
        integerList = Arrays.asList(1, 2, 7, 4, 5);

        // f.i
        Consumer<List<Integer>> consumerMR = Collections::sort;
        consumerMR.accept(integerList);

        integerList.forEach(System.out::println);

        // f.ii
        // Compiler knows by analysing the surrounding context; that is, it sees that the right-hand side is
        // a Consumer of type List<Integer>. Therefor it uses the Collections.sort(l) version.
        // Collections.sort(l, c) would have needed a Consumer<List<Integer>, Comparator>

    }

    // 2
    private static void boundMR() {
        System.out.println("--- 2 ---");
        // a
        String name = "Mr. Joe Bloggs";

        // b
        Predicate<String> predicateLam = prefix -> name.startsWith(prefix);

        // c
        System.out.println("Lambda test for Mr: "+ predicateLam.test("Mr"));

        // d
        System.out.println("Lambda test for Ms: "+ predicateLam.test("Ms"));

        // e
        Predicate<String> predicateMR = name::startsWith;

        // f
        System.out.println("MR test for Mr: "+ predicateMR.test("Mr"));
        System.out.println("MR test for Ms: "+ predicateMR.test("Ms"));
    }

    // 3
    private static void unboundMR() {
        System.out.println("--- 3 ---");
        // a
        Predicate<String> predicateLam = s -> s.isEmpty();

        // b
        System.out.println("b");
        System.out.println(predicateLam.test(""));

        // c
        System.out.println("c");
        System.out.println(predicateLam.test("xyz"));

        // d
        Predicate<String> predicateMR = String::isEmpty;

        // e
        System.out.println("e");
        System.out.println(predicateMR.test(""));
        System.out.println(predicateMR.test("xyz"));

        // f
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.startsWith(s2);
        System.out.println("f");
        System.out.println(biPredicate.test("Mr. Joe Bloggs", "Mr"));
        System.out.println(biPredicate.test("Mr. Joe Bloggs", "Ms"));

        // g
        BiPredicate<String, String> biPredicateMR = String::startsWith;
        System.out.println("g");
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr"));
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms"));
    }

    // 4
    private static void constructorMR() {
        System.out.println("--- 4 ---");
        // a
        Supplier<List<String>> supplierLam = () -> new ArrayList<>();

        // b
        List<String> list = supplierLam.get();

        // c
        list.add("Lambda");

        // d
        System.out.println("d");
        list.forEach(System.out::println);

        // e
        Supplier<List<String>> supplierMR = ArrayList::new;

        // e.i
        list = supplierMR.get();

        // e.ii
        list.add("Method Reference");

        // e.iii
        System.out.println("e");
        list.forEach(System.out::println);

        // f
        Function<Integer, ArrayList<String>> functionLam = cap -> new ArrayList<>(cap);
        list = functionLam.apply(10);
        list.add("Lambda");
        System.out.println("f");
        list.forEach(System.out::println);

        // g
        Function<Integer, ArrayList<String>> functionMR = ArrayList::new;
        list = functionMR.apply(20);
        list.add("Method Reference");
    }
}
