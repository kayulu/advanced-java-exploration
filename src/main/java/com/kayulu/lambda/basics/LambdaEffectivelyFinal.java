package com.kayulu.lambda.basics;

import java.util.function.UnaryOperator;

public class LambdaEffectivelyFinal {
    public static void main(String[] args) {
        int fac = 10;   // effectively final

        // Note: local variables referenced within the lambda must be final or effectively final
        // As soon as a lambda expression uses a var from its surrounding scope that value is captured
        // and represents a snapshot of the value.
        UnaryOperator<Integer> inc = i -> i * fac; // fac is captured now, and can't be changed

        // A captured value can't even be changed inside the lambda itself.
//        UnaryOperator<Integer> inc2 = i -> {
//            fac++; // can't change inside lambda as well
//            return i*fac;
//        };

        //Compiler error: Variable used in lambda expression should be final or effectively final
//        fac = 20;

        // this constraint ensures that the captured variables remain consistent and predictable throughout the lambda
        // expression. If it was possible than the lambda would behave different everytime the value used from outside
        // changes.

    }
}
