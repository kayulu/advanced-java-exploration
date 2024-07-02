package com.kayulu.java21.recordPattern;

public class RecordPatternTest {
    public static void main(String[] args) {
        Person p = new Person("Kay", 48);
        Pair<String> pair = new Pair<>("Germany", "Berlin");

        typePattern(p);
        patternMatching(p);
        patternMatching(pair);

        Person p1 = new Person("Joe Bloggs", 23);
        Person p2 = new Person("Mary Bloggs", 22);
        Player player1 = new Player(p1, Ability.WEAK);
        Player player2 = new Player(p2, Ability.STRONG);
        Doubles doubles = new Doubles(player1, player2);

        nesting(doubles);
    }

    // Type Pattern:
    // are used to test whether an object is of a particular type and, if so,
    // to cast the object to that type in a single operation.
    private static void typePattern(Object obj) {
        if(obj instanceof Person p) {
            String name = p.name();
            int age = p.age();

            System.out.println("TP: " + name + " : " + age);
        }
    }

    // Record pattern:
    // are used to deconstruct record instances.
    // They allow you to extract the components of a record directly within a pattern,
    // making it easier to work with the data stored in records.
    private static void patternMatching(Object obj) {
        if(obj instanceof Person(String n, Integer a)) { // this is the record pattern
            System.out.println("PM: " + n + " : " + a);
        } else if (obj instanceof Pair<?> p) {  //because of type erasure at runtime, raw type must be used 'Pair<?>'
            System.out.println("PM: " + p.x() + " : " + p.y());

            // how to check for specific types of the components of the record
            // type pattern
            if(p.x() instanceof String && p.y() instanceof String) {
                System.out.println("Type: Pair<String, String>");
            }
        }
    }

    static void nesting(Doubles doubles) {
        if(doubles instanceof Doubles(Player p1, Player p2)) {
            System.out.println(p1.person().name() + " : " + p1.ability());
        }

        // complex nesting; Person is further decomposed
        if(doubles instanceof Doubles(Player(Person p1, Ability a1), Player p2)) {
            System.out.println(p1.name() + " : " + a1);
        }

        // local variable type inference (LVTI) works as well
        if(doubles instanceof Doubles(Player(var p1, var a), var p2)) {
            System.out.println(p1.name() + " : " + a);
        }
    }
}
