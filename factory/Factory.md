## Factory - Return one object as your requirement

## What's Factory?

- Factory Method is a creational design pattern that Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## Example Problem

- Its purpose is make your code loose coupled and more flexible. In the ordinary way, when you need to set up a `CoffeeFactory` you will type something like :

```java
public abstract class Coffee {
    String typeName;
    int voteOfUsers;
    boolean isCoveredByLatteArt();
    ...
}

public class Americano extends Coffee {
    String typeName = "Americano";
    ...
}

public class Capucino extends Coffee {
    String typeName = "Capucino";
    ...
}
```

- But that make your code depend on the extensions of `Coffee`. If missing interface, you will be difficult to recognize what is a Coffee.

```java
Coffee americano = new Americano();
Coffee capucino = new Capucino();
```

- Now your sir want to extend coffee's type to `Espressino` without change their code so much, because their CoffeeShop is still working. You can create again class `Espressino` extends `Coffee`, but you must change almost code which refer to them. Now, you are need for Factory Design Pattern

## UML

<!-- ![](/factory/factory_uml.png) -->

## Implementation

```java
public interface Coffee {
    String getCoffeeName();
}
```

`Java 8 support _enum_ type, so I will use it for easier switch-case. You can use string, int or anythng other.`

```java
public enum CoffeeType {
    ESPRESSINO, CAPUCINO, AMERICANO
}
```

+ Coffee implementation
```java
public class Americano implements Coffee {
    @Override
    public String getCoffeeName() {
        return "Americano";
    }   
}

public class Espressino implements Coffee {
    @Override
    public String getCoffeeName() {
        return "Espressino";
    }
}

public class Capucino implements Coffee {
    @Override
    public String getCoffeeName() {
        return "Capucino";
    }
}
```

+ My Factory
```java
public class CoffeeFactory {
    private CoffeeFactory() {};

    public static Coffee getCoffee(CoffeeType coffeeType){
        switch (coffeeType) {
            case AMERICANO:
                return new Americano();
            case ESPRESSINO:
                return new Espressino();
            case CAPUCINO:
                return new Capucino();
            default:
                throw new IllegalArgumentException("Error, we don't supply this coffee type");
        }
    }
}
```

+ How My Factory be used
```java
public class CoffeeShop {
    public static void main(String[] args) {
         Coffee capucino = CoffeeFactory.getCoffee(CoffeeType.CAPUCINO);
        System.out.println(capucino.getCoffeeName());

        Coffee espressino = CoffeeFactory.getCoffee(CoffeeType.ESPRESSINO);
        System.out.println(espressino.getCoffeeName());

        Coffee americano = CoffeeFactory.getCoffee(CoffeeType.AMERICANO);
        System.out.println(americano.getCoffeeName());
    }
}
```

## Result
<!-- ![](/factory/resuly-factory.png) -->

## Where to use it?
- When we need reduce dependability among modules (loose coupling)
- When we want to create a "easy-to-scale" product
- When we want to keep the logic of object creation process from user
- When we want to manage life cycle of objects created by Factory. 
- This DP help to implement `naming convention` in team.

## Where used it?
- JDK : util.Calendar, NumberFormat,...
- Redefinement of it : Dependency Injection (Spring, .Net, Django)
- BeanFactory in Spring Framework, SessionFactory in Hibernate