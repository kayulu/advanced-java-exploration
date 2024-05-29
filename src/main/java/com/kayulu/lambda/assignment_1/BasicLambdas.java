package com.kayulu.lambda.assignment_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {
    public static void main(String[] args) {
        BasicLambdas bl = new BasicLambdas();

        bl.consumer();
        bl.supplier();
        bl.predicate();

        System.out.println("check 4 is even: " + BasicLambdas.check(4, p -> p % 2 == 0));
        System.out.println("check 7 is even:  " + BasicLambdas.check(7, p -> p % 2 == 0));

        System.out.println("check contains Mr.: " + BasicLambdas.check("Mr. Joe Bloggs", s -> s.contains("Mr.")));
        System.out.println("check contains Mr.: " + BasicLambdas.check("“Ms. Ann Bloggs", s -> s.contains("Mr.")));

        Person mike = new Person("Mike", 33, 1.8d);
        Person ann = new Person("Ann", 13, 1.4d);

        Predicate<Person> predicateAdult = p -> p.getAge() >= 18;
        System.out.println("check is adult (Mike): " + check(mike, predicateAdult));
        System.out.println("check is adult (Ann): " + check(ann, predicateAdult));

        bl.function();

        List<Person> listPeople = getPeople();
        BasicLambdas.sortName(listPeople);
        BasicLambdas.sortAge(listPeople);
        BasicLambdas.sortHeight(listPeople);
    }

    private void consumer() {
        Printable<String> printableLam = (p) -> System.out.println(p);
        Consumer<String> consumerLam = (p) -> System.out.println(p);
        Consumer<String> consumerMR = System.out::println;

        System.out.println("---- Printable ------");
        printableLam.print("Printable lambda");
        consumerMR.accept("Printable lambda");
        consumerMR.accept("Printable lambda");

    }

    private void supplier() {
        Retrievable<Integer> retrievableLam = () -> 77;
        Supplier<Integer> supplierLam = () -> 77;

        System.out.println("---- Retrievable ------");
        System.out.println(retrievableLam.retrieve());
    }

    private void predicate() {
        Evaluate<Integer> evaluate = i -> i < 0;
        Predicate<Integer> predicate = i -> i < 0;

        System.out.println("---- Evaluate -----");
        System.out.println("Evaluate -1: " + evaluate.isNegative(-1));
        System.out.println("Evaluate 1: " + evaluate.isNegative(1));

        System.out.println("Predicate -1: " + predicate.test(-1));
        System.out.println("Predicate 1: " + predicate.test(1));

    }

    private void function() {
        Functionable<Integer, String> functionable = i -> "Number is: " + i;
        Function<Integer, String> function = i -> "Number is: " + i;

        System.out.println(functionable.applyThis(25));
        System.out.println(function.apply(25));
    }

    private static <T> boolean check(T t, Predicate<T> p) {
        return p.test(t);
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void sortName(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getName));

        System.out.println("Sort by name:");
        persons.forEach(p -> System.out.println(p.getName()));
        persons.forEach(System.out::println);
    }

    private static void sortAge(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getAge));

        System.out.println("Sort by age:");
        persons.forEach(System.out::println);
    }

    private static void sortHeight(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getHeight));

        System.out.println("Sort by height:");
        persons.forEach(System.out::println);
    }
}
