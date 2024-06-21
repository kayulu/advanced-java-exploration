package com.kayulu.privIntMeth;

/*
Private methods in interfaces, introduced in Java 11, allow you to encapsulate and reuse code within an interface.
They solve problems related to code duplication, maintenance, and encapsulation by enabling the sharing of common logic
between default and static methods in a clean and organized manner. This feature enhances the capability of interfaces to
provide more structured and maintainable code without exposing implementation details to implementing classes.
 */

interface Tennis{
    private static void hit(String stroke){
        System.out.println("Hitting a "+stroke);
    }

    private void smash(){ hit("smash"); }
    default void forehand(){ hit("forehand"); }

    static void backhand(){
        // smash();// static to instance not allowed!
        hit("backhand");
    }
}

public class SportTest implements Tennis{
    public static void main(String[] args) {
        new SportTest().forehand(); // Hitting a forehand
        Tennis.backhand();          // Hitting a backhand
//        SportTest.hit();
//        new SportTest().smash();
    }
}

/*
public interface MyInterface {

    // Abstract method (implicitly public and abstract)
    void abstractMethod();

    // Default method (implicitly public)
    default void defaultMethod() {
        System.out.println("Default Method");
    }

    // Static method (implicitly public)
    static void staticMethod() {
        System.out.println("Static Method");
    }

    // Private method (instance)
    private void privateMethod() {
        System.out.println("Private Method");
    }

    // Private method (static)
    private static void privateStaticMethod() {
        System.out.println("Private Static Method");
    }
}
*/
