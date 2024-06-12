package com.kayulu.lambda.basics;

@FunctionalInterface
interface I {
    void m();
}

public class BasicLambdas {
    public static void main(String[] args) {
        // pre-Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m()");
            }
        };
        i.m();

        // Java 8 - Lambda version
        I i2 = () -> {
            System.out.println("Lambda version");
        };
        i2.m();

        I i3 = () -> System.out.println("Lambda version");
        i3.m();
    }
}
