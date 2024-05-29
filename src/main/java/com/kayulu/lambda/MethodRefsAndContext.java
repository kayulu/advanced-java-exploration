package com.kayulu.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

// Context and Target Type:
// The compiler determines the type of method reference by looking at the target type (left-hand side of the assignment),
// which is typically a functional interface.
// This target type defines the method signature that the method reference must match.

public class MethodRefsAndContext {

    public static void main(String[] args) {
//        Supplier<Integer> supplierLam = () -> Person.howMany();
        Supplier<Integer> supplierMr = Person::howMany;     // <----- same syntax
        System.out.println("Supplier: " + supplierMr.get());

//        Function<Person, Integer> functionLam = p -> Person.howMany(p);
        Function<Person, Integer> functionMr = Person::howMany;     // <----- same syntax
        System.out.println("Function: " + functionMr.apply(new Person()));

//        BiFunction<Person, Person, Integer> biFunctionLam = (p1, p2) -> Person.howMany(p1, p2);
        BiFunction<Person, Person, Integer> biFunctionMr = Person::howMany;     // <----- same syntax
        System.out.println("BiFunction: " + biFunctionMr.apply(new Person(), new Person()));

    }
}

class Person {
    public static Integer howMany(Person... persons) {
        return persons.length;
    }
}