# Singleton - One of a Kind Objects

## What's Singleton ?
- The Singleton Pattern - like its name : "singleton" -
assures that at any one time
there is __only one instance__ of the Singleton object and  provides a __global access point__ to this instance.
In other words, the Singleton's purpose is to control object creation, limiting the number of objects to one only per application.

## UML
<!-- ![](/singleton/singleton_uml.png) -->

## How to implement Singleton ?
```java
package singleton;

public class Duck {
    private static Duck instance;

    private Duck() {
    }

    public static Duck getInstance() {
        if (instance == null) {
            instance = new Duck();
        }
        return instance;
    }
    // other methods
}
```

```java
package singleton;

public class DuckShop {
    public static void main(String[] args) {
        Duck _duck1 = Duck.getInstance();
        Duck _duck2 = Duck.getInstance();
        System.out.println(_duck1.equals(_duck2));  // true
    }
}
```

## Where used it?
- Singeton pattern is used for logging, driver objects, caching and thread pool.
- It is used in some standard API of Java (java.lang.Runtime, java.util.Calendar, java.awt.Desktop)
- Some other DP used Singleton for its implementation: Abstract Factory, Builder, Facade ... 

`Note` : Implementation like above code is Eager Implementation. In reality, it can be destructured by reflection API in Java. You can search about some other implement ways (synchronize, double-check,...).