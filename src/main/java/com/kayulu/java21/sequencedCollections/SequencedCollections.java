package com.kayulu.java21.sequencedCollections;

import java.util.*;

public class SequencedCollections {
    public static void main(String[] args) {
        System.out.println("--- Sequenced Collections");
        seqCol();

        System.out.println("--- Sequenced Set");
        seqSet();

        System.out.println("--- Sequenced Map");
        seqMap();
    }

    private static void seqCol() {
        SequencedCollection<String> seq = new ArrayList<>();
        seq.addFirst("A"); // A
        seq.addFirst("B"); // B A
        seq.addLast("C"); //  B A C
        seq.addLast("D"); //  B A C D
        seq.addLast("D"); //  B A C D

        System.out.println(seq);
        System.out.println("getFirst(): " + seq.getFirst());
        System.out.println("getLast(): " + seq.getLast());
        System.out.println("removeFirst(): " + seq.removeFirst());
        System.out.println("removeLast(): " + seq.removeLast());
        System.out.println(seq);

        System.out.println("Forwards...");
        for (String s : seq)
            System.out.println(s);

        System.out.println("Backwards...");
        for (String s : seq.reversed())
            System.out.println(s);

    }

    private static void seqSet() {
        SequencedSet<String> seq = new LinkedHashSet<>();

        seq.addFirst("A"); // A
        seq.addFirst("B"); // B A
        seq.addLast("C"); //  B A C
        seq.addLast("D"); //  B A C D
        seq.addLast("D"); //  B A C D D

        System.out.println(seq);
        System.out.println("getFirst(): " + seq.getFirst());
        System.out.println("getLast(): " + seq.getLast());
        System.out.println("removeFirst(): " + seq.removeFirst());
        System.out.println("removeLast(): " + seq.removeLast());
        System.out.println(seq);

        System.out.println("Forwards...");
        for (String s : seq)
            System.out.println(s);

        System.out.println("Backwards...");
        for (String s : seq.reversed())
            System.out.println(s);
    }

    private static void seqMap() {
        // a SequencedMap is a Map whose entries have a defined encounter order
        SequencedMap<Integer, String> map = new LinkedHashMap<>();

        map.putFirst(1, "Selma");
        map.putFirst(2, "Kayhan");
        map.putFirst(3, "Serap");
        map.putLast(4, "Micah");
        System.out.println(map);
        System.out.println("firstEntry(): " + map.firstEntry());
        System.out.println("lastEntry(): " + map.lastEntry());
        System.out.println("pollFirstEntry(): " + map.pollFirstEntry());
        System.out.println("pollLastEntry(): " + map.pollLastEntry());
        System.out.println(map);

        System.out.println("Forwards...");
        for (Map.Entry<Integer, String> e : map.entrySet())
            System.out.println(e.getKey() + " : " + e.getValue());

        System.out.println("Backwards...");
        for (Map.Entry<Integer, String> e : map.reversed().entrySet())
            System.out.println(e.getKey() + " : " + e.getValue());
    }
}
