package com.kayulu.collections.assignment;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapsToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps(){
        Map<String, Integer> cToS    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> cToP       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> pToS  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        cToS.put("JustForLaughs", 120_000);
        cToS.put("JustForGags", 10_000);
        cToS.put("ContemplationTechniques", 10_000);
        cToS.put("A New Earth", 20_000);

        // channel -> publisher
        // K -> V2
        cToP.put("JustForLaughs", "Charlie Chaplin");
        cToP.put("JustForGags", "Charlie Chaplin");
        cToP.put("ContemplationTechniques", "Echhart Tolle");
        cToP.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)
        // V2 -> V1
        cToP.forEach(
                (c, p) -> {
                    if(pToS.containsKey(p))
                        pToS.put(p, pToS.get(p) + cToS.get(c));
                    else
                        pToS.put(p, cToS.get(c));
                }
        );

        // 2. Output "publisherToSubscribers"
        pToS.forEach((key, value) -> System.out.println(key + " : " + value));

        // 3. Who has the most/least subscribers?
        pToS.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .ifPresent(System.out::println);

        pToS.entrySet()
                .stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .ifPresent(System.out::println);
    }
}

