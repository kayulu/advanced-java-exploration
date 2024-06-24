**Automatic modules** are a feature in the Java Module System that allow JAR files without module descriptors (`module-info.java`) to be used as modules. This facilitates the migration of existing Java libraries and applications to the modular system without requiring immediate modifications to every JAR file.

### Key Points about Automatic Modules:

1. **Automatic Module Name**: The name of the automatic module is derived from the JAR file name. For example, a JAR file named `mylib-1.0.jar` would result in an automatic module named `mylib.1.0`.

2. **Exporting All Packages**: All packages in an automatic module are automatically exported. This means that all public classes and interfaces are accessible to other modules.

3. **Readability**: Automatic modules can read other automatic modules and named modules. Conversely, named modules can read automatic modules if they specify a `requires` directive.

4. **No `module-info.java`**: Since the JAR file does not contain a `module-info.java`, it becomes an automatic module as soon as it is placed on the module path.

### Example

Assume you have a legacy JAR file `legacy-lib.jar` which you want to use in your modular project.

#### Step 1: Place `legacy-lib.jar` on the module path

When compiling or running your modular project, place `legacy-lib.jar` on the module path.

#### Step 2: Use the Automatic Module

In your module's `module-info.java`, you can require the automatic module using its derived name:

```java
module mymodule {
    requires legacy.lib;
    // Other module directives
}
```

### Summary

Automatic modules provide a way to include existing, non-modularized JAR files in the Java Module System without requiring immediate modifications. They help ease the transition to a fully modularized system by allowing gradual migration.