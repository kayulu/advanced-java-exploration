package com.kayulu.collections.generics;

public class GenericMethods {

    public static void main(String[] args) {
        genericMethod("SK");    // SK
        genericMethod(1.1);     // 1.1

        register(new Dog(), "Shep", 3);     // Register: Shep; 3
        register(new Cat(), "Whiskers", 2); // Register: Whiskers; 2

        MyGenericClass<Integer> myGenI = createGeneric(4);
        System.out.println(myGenI.getInstance());  // 4
    }

    public static <T> void genericMethod(T t){
        MyGenericClass<T> myGen = new MyGenericClass<>(t);
        System.out.println(myGen.getInstance());
    }

    public static <T, U, V> void register(T t, U u, V v){
        Register<T, U, V> register = new Register<>(t, u, v);
        System.out.println("Register: "+register.getName()+"; "+register.getAge());
    }

    public static <T> MyGenericClass<T> createGeneric(T t){
        return new MyGenericClass<>(t);
    }
}


