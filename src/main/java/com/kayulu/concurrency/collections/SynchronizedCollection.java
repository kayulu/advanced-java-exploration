package com.kayulu.concurrency.collections;

import java.util.*;

public class SynchronizedCollection {
    public static void main(String[] args) {
//        synchronizedList();
        synchronizedMap();

    }

    private static void synchronizedList() {
        List<String> dogTypes = new ArrayList<>();
        dogTypes.add("German Shepherd");
        dogTypes.add("Labrador");
        List<String> dogTypesSyn = Collections.synchronizedList(dogTypes);

        for(String dog : dogTypesSyn) {
            System.out.println("dog: " + dog);
            dogTypesSyn.remove(dog);
        }

        System.out.println(dogTypesSyn);
    }

    private static void synchronizedMap() {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");

        Map<String, String> concurrentHashMap = Collections.synchronizedMap(capitalCities);

        for(String key : concurrentHashMap.keySet()) {
            System.out.println(key + " is the capital of " + concurrentHashMap.get(key));
            // this will throw a ConcurrentModificationException, although the map itself is synchronized this is not
            // the case for the iterator the enhanced for-loop uses
            concurrentHashMap.remove(key);
        }
    }
}