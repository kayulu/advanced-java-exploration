In the Java Module System, **services** provide a way for modules to offer implementations of specific interfaces or abstract classes (service interfaces) that other modules can consume. This is a part of the Service Provider Interface (SPI) mechanism, which allows for a decoupled architecture where modules can discover and use implementations at runtime.

### Key Components

1. **Service Interface**: An interface or an abstract class that defines the contract for the service.

2. **Service Provider**: A class that implements the service interface.

3. **Service Consumer**: A module that uses the service.

### Key Directives

- **`provides ... with`**: This directive is used in the `module-info.java` file of the service provider module to specify that it provides an implementation for a service interface.

- **`uses`**: This directive is used in the `module-info.java` file of the service consumer module to specify that it relies on a service interface.

### Example

1. **Module for Service Contract (`moduleA`)**:
    - Defines and exports the service interface `MyService`.

2. **Module for Service Implementation (`moduleB`)**:
    - Implements `MyService` and provides the implementation.

3. **Module for Service Consumer (`moduleC`)**:
    - Uses the service `MyService`.

### Project Structure

```
my-modular-project
- src
  - moduleA
    - com/kayulu/modulea/MyService.java
    - module-info.java
  - moduleB
    - com/kayulu/moduleb/MyServiceImpl.java
    - module-info.java
  - moduleC
    - com/kayulu/modulec/ServiceConsumer.java
    - module-info.java
```

### Module Code

#### Define a Service Interface `moduleA`

```java
package com.kayulu.modulea;

public interface MyService {
    void execute();
}

```
**`module-info.java`**:
```java
module moduleA {
    exports com.kayulu.modulea;
}
```

#### Provide an Implementation `moduleB`

```java
package com.kayulu.moduleb;

import com.kayulu.modulea.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void execute() {
        System.out.println("Executing MyServiceImpl");
    }
}
```

**`module-info.java`**:
```java
module moduleB {
    requires moduleA;
    provides com.kayulu.modulea.MyService with com.kayulu.moduleb.MyServiceImpl;
}
```

#### Consume the Service `moduleC`

**`ServiceConsumer.java`**:
```java
package com.kayulu.modulec;

import com.kayulu.modulea.MyService;
import java.util.ServiceLoader;

public class ServiceConsumer {
    public static void main(String[] args) {
        ServiceLoader<MyService> loader = ServiceLoader.load(MyService.class);
        for (MyService service : loader) {
            service.execute();
        }
    }
}
```

**`module-info.java`**:
```java
module moduleC {
    requires moduleA;
    uses com.kayulu.modulea.MyService;
}
```

### Compiling the Modules

1. **Create Output Directories**:

```sh
mkdir -p out/moduleA out/moduleB out/moduleC
```

2. **Compile `moduleA`**:

```sh
javac -d out/moduleA src/moduleA/module-info.java src/moduleA/com/kayulu/modulea/MyService.java
```

3. **Compile `moduleB`**:

```sh
javac --module-path out -d out/moduleB src/moduleB/module-info.java src/moduleB/com/kayulu/moduleb/MyServiceImpl.java
```

4. **Compile `moduleC`**:

```sh
javac --module-path out -d out/moduleC src/moduleC/module-info.java src/moduleC/com/kayulu/modulec/ServiceConsumer.java
```

### Running the `ServiceConsumer` Class

To run the `ServiceConsumer` class in `moduleC`, use the following command:

```sh
java --module-path out -m moduleC/com.kayulu.modulec.ServiceConsumer
```

This example illustrates how to define, implement, and use a service in the Java Module System, including the necessary `javac` and `java` commands to compile and run the modules.