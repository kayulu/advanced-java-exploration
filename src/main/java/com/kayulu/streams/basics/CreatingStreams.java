package com.kayulu.streams.basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) throws IOException {
//        fromArray();
//        creatingPrimitiveStreams();
//        fromFile();

        // infinite stream
//        Stream<Integer> infStream = Stream.generate(() -> (int) (Math.random() * 10));
        Stream<Integer> infStream = Stream.iterate(2, i -> i + 2);
        infStream
                .limit(10)
                .forEach(System.out::println);

        fromCollection();

    }

    private static void fromFile() throws IOException {
        Path filePath = Paths.get("src/main/resources/Simple");
        List<String> lines = new ArrayList<>();

        try(Stream<String> fileStream = Files.lines(filePath)) {
            fileStream.forEach(lines::add);

            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fromArray() {
        Double[] numbers = {1.1, 2.2, 3.3};
        Stream<Double> stream1 = Arrays.stream(numbers);

        long count = stream1.count();

        System.out.println("Number of elements: " + count);

        Stream<Double> stream2 = Stream.of(numbers);

        Stream<String> stream3 = Stream.of("Hello", "World");

        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Kayhan", 94);
        namesToAges.put("Selma", 23);
        namesToAges.put("Serap", 32);

        System.out.println("Number of elements: " + namesToAges.entrySet().stream().count());
    }

    public static void creatingPrimitiveStreams(){
        int[] ia    = {1,2,3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la   = {1L, 2L, 3L};

        IntStream iStream1      = Arrays.stream(ia);
        DoubleStream dStream1   = Arrays.stream(da);
        LongStream lStream1     = Arrays.stream(la);
        System.out.println(iStream1.count() + ", " +
                dStream1.count() + ", " + lStream1.count());// 3, 3, 3

        IntStream iStream2       = IntStream.of(1, 2, 3);
        DoubleStream dStream2    = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream lStream2      = LongStream.of(1L, 2L, 3L);
        System.out.println(iStream2.count() + ", " +
                dStream2.count() + ", " + lStream2.count());// 3, 3, 3

    }

    public static void fromCollection(){

        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        // using stream() which is a default method in Collection interface
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number of elements: "+streamAnimals.count()); // 3

        // stream() is a default method in the Collection interface and therefore
        // is inherited by all classes that implement Collection. Map is NOT one
        // of those i.e. Map is not a Collection. To bridge between the two, we
        // use the Map method entrySet() to return a Set view of the Map (Set
        // IS-A Collection).
        Map<String, Integer> namesToAges = new HashMap<>();

        namesToAges.put("Mike", 22);
        namesToAges.put("Mary", 24);
        namesToAges.put("Alice", 31);

        System.out.println("Number of entries: "+
                namesToAges
                        .entrySet() // get a Set (i.e. Collection) view of the Map
                        .stream()   // stream() is a default method in Collection
                        .count());  // 3
    }
}
