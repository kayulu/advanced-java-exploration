package com.kayulu.collections.hashCodeEquals;

// Note:
// hashCode is used to find the right bucket (different object can happen to have the same hashcode; they are put in the same bucket)
// inside the bucket-list, equals is used to find the right object
//
// if two objects are equal, they also must have the same hashcode
// therefore the calculation of the hashcode must consider the fields that make an object equal

// also: do not use transient fields for calculating the hashcode. This is because this value will not be serialized
// and therefore will be absent when the object is deserialized.

class Foo {
    private int fooValue;
    public Foo(int value) {fooValue = value;}
    int getFooValue() { return fooValue; }

    @Override
    public boolean equals(Object other) {
        return other instanceof Foo && fooValue == ((Foo) other).getFooValue();
    }

    // if overrides equal it must override hashCode as well
    @Override
    public int hashCode() {
        return fooValue * 12;
    }
}

public class FooTest {
    public static void main(String[] args) {
        Foo a = new Foo(2);
        Foo b = new Foo(2);

        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
