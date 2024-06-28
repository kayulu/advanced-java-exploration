package com.kayulu.java17;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

record PersonShort(String name, int age){}  // has implicit canonical constructor

record Person(String name, int age) implements Comparable<Person> {
    // custom compact constructor with safety check
    public Person {
        if(age < 0)
            throw new IllegalArgumentException("Person died " + (-1 * age) + " year ago!");
    }

    // non canonical constructor
    public Person(int age, String name) {
        this(name, 99);  // using non canonical must delegate to canonical constructor
    }

    // non canonical constructor
    public Person() {
        this("default", 299);   // using non canonical must delegate to canonical constructor
    }

    @Override
    public String name() {  // we can override the default implementation
        return name.toUpperCase();
    }

    public int nameLength() {
        return this.name.length();
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name); // natural order imposed on this record
    }
}

//class X extends Person {} // a record is final and can't be extended

public class RecordTest {
    public static void main(String[] args) {
        PersonShort ps = new PersonShort("Kayhan", 48);

//        Person dead = new Person("xx", -1);

        Person p = new Person("Kayhan", 48);
        Person p2 = new Person("Kayhan", 48);
        Person p3 = new Person(99, "Kayhan2");

        System.out.println("p.equals(p2): " + p.equals(p2));
        System.out.println("p.hashCode(): " + p.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p.toString(): " + p);
        System.out.println(p.nameLength());

        System.out.println(p3);
        System.out.println(p.name());
        System.out.println(p.age());

        List<Person> personList = Arrays.asList(new Person("x", 12), new Person("a", 23));
        System.out.println(personList);

        Collections.sort(personList);   // sort using natural order
        System.out.println(personList);

//        personList.sort((pe1, pe2) -> pe1.age() - pe2.age());   // sort using different order
        personList.sort(Comparator.comparingInt(Person::age));

        System.out.println(personList);
    }
}

