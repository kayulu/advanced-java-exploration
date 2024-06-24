**Sealed classes** in Java are a feature introduced in Java 17 that allow a class to control which other classes or interfaces can extend or implement it. This helps in providing a more controlled and explicit inheritance hierarchy, enhancing encapsulation and maintainability.

### Key Points about Sealed Classes:

1. **Declaration**: A sealed class or interface is declared with the `sealed` modifier, and it must specify the permitted subclasses or implementations using the `permits` clause.

2. **Permitted Subclasses**: Only the classes or interfaces listed in the `permits` clause can extend or implement the sealed class or interface. This list must be exhaustive and known at compile time.

3. **Final, Non-Sealed, and Sealed Subclasses**:
    - A permitted subclass can be declared as `final`, which means no further subclassing is allowed.
    - A permitted subclass can be declared as `non-sealed`, which means it can be subclassed without restriction.
    - A permitted subclass can also be declared as `sealed` itself, continuing the sealing hierarchy.

### Example

Here's a simple example demonstrating the usage of sealed classes:

**Base Sealed Class**:
```java
public sealed class Shape permits Circle, Square, Rectangle {
    // common methods and fields for shapes
}
```

**Permitted Subclasses**:

**Circle**:
```java
public final class Circle extends Shape {
    // implementation specific to Circle
}
```

**Square**:
```java
public sealed class Square extends Shape permits ColoredSquare {
    // implementation specific to Square
}
```

**ColoredSquare**:
```java
public non-sealed class ColoredSquare extends Square {
    // implementation specific to ColoredSquare
}
```

**Rectangle**:
```java
public final class Rectangle extends Shape {
    // implementation specific to Rectangle
}
```

### Benefits

- **Controlled Inheritance**: Ensures that the superclass's behavior is extended only by known, trusted subclasses.
- **Enhanced Readability**: Makes the inheritance hierarchy explicit and easier to understand.
- **Improved Maintainability**: Limits the risk of unintended subclassing and the associated maintenance burden.

Sealed classes provide a powerful tool for API designers to create robust and well-defined inheritance structures.