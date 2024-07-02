# Type and Record Pattern

In Java, both type patterns and record patterns are part of the language's pattern matching capabilities, but they are used in different contexts and serve different purposes. Here's a brief explanation of each:

### Type Pattern

**Type patterns** are used to test whether an object is of a particular type and, if so, to cast the object to that type in a single operation. They simplify the common pattern of using `instanceof` followed by a cast.

#### Example:
```java
Object obj = "Hello, World!";
if (obj instanceof String s) {
    // 's' is now a String, and you can use it directly
    System.out.println(s.toUpperCase());
}
```

In this example:
- `instanceof String s` is a type pattern.
- It checks if `obj` is an instance of `String`.
- If true, it declares a new variable `s` of type `String` and initializes it with `obj`.

### Record Pattern

**Record patterns** are used to deconstruct record instances. They allow you to extract the components of a record directly within a pattern, making it easier to work with the data stored in records.

#### Example:
```java
public record Point(int x, int y) {}

Object obj = new Point(3, 4);
if (obj instanceof Point(int x, int y)) {
    // 'x' and 'y' are now extracted from the Point record
    System.out.println("Point at (" + x + ", " + y + ")");
}
```

In this example:
- `instanceof Point(int x, int y)` is a record pattern.
- It checks if `obj` is an instance of `Point`.
- If true, it deconstructs the `Point` record into its components `x` and `y`.

### Key Differences

1. **Usage Context**:
   - **Type Pattern**: Used to check the type of an object and cast it if the check is successful.
   - **Record Pattern**: Used to match and deconstruct record instances, extracting their components directly.

2. **Syntax**:
   - **Type Pattern**: `instanceof Type variableName`
   - **Record Pattern**: `instanceof RecordType(componentType1 component1, componentType2 component2, ...)`

3. **Purpose**:
   - **Type Pattern**: Simplifies type checking and casting.
   - **Record Pattern**: Simplifies working with immutable data carried by records by deconstructing them directly in pattern matching.

### Combined Example

Here's an example that shows both type and record patterns working together:

```java
public record Point(int x, int y) {}
public record Circle(Point center, int radius) {}

Object obj = new Circle(new Point(1, 2), 5);
if (obj instanceof Circle(Point center, int radius)) {
    if (center instanceof Point(int x, int y)) {
        System.out.println("Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}
```

In this combined example:
- The outer pattern `instanceof Circle(Point center, int radius)` is a record pattern.
- The inner pattern `instanceof Point(int x, int y)` is a nested record pattern within a type pattern check.

By understanding these differences, you can better utilize pattern matching features in Java to write more concise and readable code.