# Records

Records in Java are a special kind of class introduced in Java 14 as a preview feature and made a standard feature in **Java 16**. They are designed to be a concise way to define immutable data carriers, which means they primarily hold data and have very little additional behavior.

### Key Concepts of Java Records

1. **Immutable Data Carriers**: Records are intended to store immutable data. Once created, the state of a record instance cannot be modified.

2. **Concise Syntax**: Defining a record is much more concise than defining a traditional class. Records automatically generate common methods like `equals()`, `hashCode()`, and `toString()`.

3. **Implicit Components**: When you define a record, Java implicitly declares private final fields, a canonical constructor, and accessor methods for each component (field).

4. **Automatic Method Generation**:
    - `equals()`: Compares records by their state.
    - `hashCode()`: Generates a hash code based on the state of the record.
    - `toString()`: Returns a string representation of the record including its field values.
    - **Accessors**: For each field, an accessor method is automatically created.

5. **Canonical Constructor**: The constructor for a record is automatically created to take parameters for each field and initialize them.

6. **Custom Implementations**: While the default methods are generated automatically, you can still provide custom implementations if necessary.

7. **Inheritance**: Records cannot extend other classes (they implicitly extend `java.lang.Record`), but they can implement interfaces.

8. **Use Cases**: Records are particularly useful for data transfer objects (DTOs), value objects, and other scenarios where simple data aggregation and transport are needed.

### Example of a Record in Java

Here’s a simple example of defining and using a record in Java:

```java
public record Person(String name, int age) {
    // Implicitly includes:
    // - private final String name;
    // - private final int age;
    // - public String name() { return name; }
    // - public int age() { return age; }
    // - public boolean equals(Object o)
    // - public int hashCode()
    // - public String toString()
    
    // You can also add additional methods if needed
    public String greet() {
        return "Hello, " + name;
    }
}
```

### Usage

```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.println(person.name());  // Alice
        System.out.println(person.age());   // 30
        System.out.println(person);         // Person[name=Alice, age=30]
    }
}
```

In this example, the `Person` record has two fields: `name` and `age`. The record provides default implementations for `equals()`, `hashCode()`, and `toString()`, and accessor methods `name()` and `age()`.

### Important Concepts

1. **Compact Constructors**: You can define a more concise constructor if you need to validate or transform inputs.
2. **Local Records**: Records can also be defined locally within a method.
3. **Validation**: You can add validation logic in the constructor.
4. **Serialization**: Records are serializable by default if all of their components are serializable.

Records in Java simplify the creation of simple classes that are primarily data carriers, reducing boilerplate code and increasing readability.