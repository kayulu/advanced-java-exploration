### Overview of the Java Module System

The Java Module System, introduced in Java 9 as part of Project Jigsaw, is a major enhancement to the Java platform that addresses the challenges of building and maintaining large applications and libraries. It introduces the concept of a module, a higher-level structure above packages, to encapsulate code and manage dependencies more effectively.

#### Key Features:

1. **Modular JDK**: The JDK itself is divided into a set of modules, allowing applications to include only the necessary parts of the JDK.
2. **Encapsulation**: Modules allow you to explicitly declare which parts of your code are public and which are internal.
3. **Dependency Management**: Modules define dependencies explicitly, making it clear what modules a given module requires.
4. **Service Loading**: Modules provide a more reliable and maintainable way to implement service providers.

### Basic Concepts:

- **Module**: A collection of packages designed for reuse.
- **Module Descriptor**: A file named `module-info.java` that specifies the module’s dependencies and the packages it exports.

### Example:

Let's create a simple example to illustrate how the Java Module System works. We'll create two modules: `com.example.greetings` and `com.example.main`.

#### Step 1: Define the `com.example.greetings` Module

1. Create the directory structure for the module:

   ```
   src/com.example.greetings/module-info.java
   src/com.example.greetings/com/example/greetings/Greetings.java
   ```

2. Create the `module-info.java` for the `com.example.greetings` module:

   ```java
   // src/com.example.greetings/module-info.java
   module com.example.greetings {
       exports com.example.greetings;
   }
   ```

3. Create a simple `Greetings` class:

   ```java
   // src/com.example.greetings/com/example/greetings/Greetings.java
   package com.example.greetings;

   public class Greetings {
       public static String getGreeting() {
           return "Hello, world!";
       }
   }
   ```

#### Step 2: Define the `com.example.main` Module

1. Create the directory structure for the module:

   ```
   src/com.example.main/module-info.java
   src/com.example.main/com/example/main/Main.java
   ```

2. Create the `module-info.java` for the `com.example.main` module:

   ```java
   // src/com.example.main/module-info.java
   module com.example.main {
       requires com.example.greetings;
   }
   ```

3. Create a `Main` class that uses the `Greetings` class:

   ```java
   // src/com.example.main/com/example/main/Main.java
   package com.example.main;

   import com.example.greetings.Greetings;

   public class Main {
       public static void main(String[] args) {
           System.out.println(Greetings.getGreeting());
       }
   }
   ```

#### Step 3: Compile and Run the Modules

1. Compile the modules:

   ```sh
   javac -d out --module-source-path src $(find src -name "*.java")
   ```

2. Run the application:

   ```sh
   java --module-path out --module com.example.main/com.example.main.Main
   ```

### Explanation:

- **module-info.java**: This file is the module descriptor that defines the module's dependencies and exported packages.
    - In `com.example.greetings/module-info.java`, the `exports com.example.greetings` statement makes the `com.example.greetings` package available to other modules.
    - In `com.example.main/module-info.java`, the `requires com.example.greetings` statement specifies that this module depends on the `com.example.greetings` module.

- **Encapsulation**: By default, only the packages specified in the `exports` clause of the module descriptor are accessible to other modules. This encapsulates the internal details of a module.

- **Dependencies**: The `requires` clause explicitly declares the dependencies between modules, making the module system aware of the relationship and enabling it to manage the module path.

The Java Module System thus helps in building more maintainable, reliable, and modular applications by enforcing strong encapsulation and clear dependency management.