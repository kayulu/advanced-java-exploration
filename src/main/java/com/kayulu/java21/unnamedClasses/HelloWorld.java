int x = 5;

//HelloWorld() {} // constructor -> compiler error

void main() {

    // unnamed classes extend from Object
    System.out.println(this.toString());
    showX();
    myMethod();

    MyClass c = new MyClass();
    System.out.println(c);

//    Other other = new Other();
//    other.testHelloWorld();
}

void showX() {
    System.out.println(x);
}

public static void myMethod() {
    System.out.println("myMethod()");
}

class MyClass {

}
