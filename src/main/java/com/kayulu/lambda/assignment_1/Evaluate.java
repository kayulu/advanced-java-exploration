package com.kayulu.lambda.assignment_1;

@FunctionalInterface
public interface Evaluate<T> {
    boolean isNegative(T t);
}
