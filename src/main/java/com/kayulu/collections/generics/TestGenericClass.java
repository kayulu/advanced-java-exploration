package com.kayulu.collections.generics;

// Name conventions:
// E for elements, T for generic types
// K is a map key, V is a map value
// N is a number
// S,U,V are for multiple generic types

class MyGenericClass<T> {
    T instance;

    public MyGenericClass(T instance) {
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }
}

public class TestGenericClass {
    public static void main(String[] args) {
        MyGenericClass<String> generic = new MyGenericClass<>("Hello");
        System.out.println(generic.getInstance());

        MyGenericClass<Integer> generic2 = new MyGenericClass<>(1);
        System.out.println(generic2.getInstance());
    }
}
