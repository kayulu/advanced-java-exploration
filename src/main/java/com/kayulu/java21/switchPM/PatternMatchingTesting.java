package com.kayulu.java21.switchPM;

public class PatternMatchingTesting {
    public static void main(String[] args) {

        switchPatternMatching("Hello, World");
        switchPatternMatching(123);
        switchPatternMatching(2.3);

        switchPMWhenClause("abcde");
        switchPMWhenClause("abcd");
        switchPMWhenClause(10);

        switchColor(Primary.RED);
        switchColor21(Rainbow.VIOLET);

    }

    private static void switchPatternMatching(Object o) {
        switch (o) {
            case String s -> System.out.println("String: " + s);
            case Integer i -> System.out.println("Integer: " + i);
            default -> System.out.println("Unknown type");
        }
    }

    private static void switchPMWhenClause(Object o) {
        switch (o) {
            case String s when s.length() >= 5 -> System.out.println("long String: " + s);
            case String s when s.isEmpty() || s.length() < 5 -> System.out.println("short String: " + s);
            default -> System.out.println("Unknown type");
        }
    }

    private static void switchColor(Color c) {
        switch (c) {
//            case Primary p when p == Primary.RED : System.out.println("color: " + p); break;
            case Primary p when p == Primary.RED -> System.out.println("color: " + p);  // 'when' clause is the guard
            case Rainbow r when r == Rainbow.BLUE -> System.out.println("color: " + r);
            default -> System.out.println("Unexpected value!");
        }
    }

    // Java 21 less verbose
    private static void switchColor21(Color c) {
        switch (c) {
            case Primary.RED ->  System.out.println("color: " + Primary.RED);
            case Rainbow.VIOLET -> System.out.println("color: " + Rainbow.VIOLET);
            default -> System.out.println("Unexpected value: " + c);
        }
    }
}
