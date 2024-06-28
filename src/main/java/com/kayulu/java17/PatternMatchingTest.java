package com.kayulu.java17;

public class PatternMatchingTest {
    public static void main(String[] args) {
        getType("Hello");
        getType(new Person());
        getType(23.2);  // auto-boxing to Double

        //test instanceof
        ifStatements(new Person());
    }

    public static void getType(Object obj) {
        switch (obj) {
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case Person p -> System.out.println("Person");
            case null -> System.out.println("null");
            default -> System.out.println(obj.getClass());
        }
    }

    public static void ifStatements(Object obj) {
        if(obj instanceof Person p) {
            System.out.println(p);
        }
    }
}
