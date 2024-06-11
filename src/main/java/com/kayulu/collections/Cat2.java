package com.kayulu.collections;

public class Cat2 implements Comparable<Cat2>{
    private String name;
    private int age;

    public Cat2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object obj){ // consistency with compareTo
        if(obj instanceof Cat2){
            Cat2 otherCat = (Cat2)obj;
            if(name.equals(otherCat.getName()))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Cat2 otherCat){ // natural sort order is by name
        return name.compareTo(otherCat.getName());
    }
}
