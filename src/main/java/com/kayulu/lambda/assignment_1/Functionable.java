package com.kayulu.lambda.assignment_1;

@FunctionalInterface
public interface Functionable<T, R> {
    R applyThis(T t);
}
