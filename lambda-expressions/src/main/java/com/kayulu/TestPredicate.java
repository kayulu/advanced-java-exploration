package com.kayulu;

import java.util.function.Predicate;

@FunctionalInterface
interface Evaluate<T> {
    boolean isNegative(T t);
}

public class TestPredicate {
    public static void main(String[] args) {
        Evaluate<Integer> eval = (t) -> t < 0;  // evaluate by using own functional interface

        System.out.println("Evaluate: " + eval.isNegative(20));

        Predicate<Integer> isNegative = (t) -> t < 0; // evaluate/test by using predefined functional interface

        System.out.println("-1 is negative: " + isNegative.test(-1));
        System.out.println("1 is negative: " + isNegative.test(1));

        Predicate<Integer> isEven = t -> t % 2 == 0;

        System.out.println("10 is even: " + isEven.test(10));
        System.out.println("11 is even: " + isEven.test(11));

        // using static function
        boolean result = TestPredicate.check(11, isEven);
        System.out.println("11 is even?: " + result);

        boolean result2 = TestPredicate.check("Kayhan", t -> t.contains("y"));
        System.out.println("Kayhan contains 'y': " + result2);
    }

    // note that T is the Type Parameter
    // it tells the compiler that T is a type
    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}
