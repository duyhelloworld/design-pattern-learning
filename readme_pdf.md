# Design Pattern - One of success keys for good software developers

*`This essay's examples are written in Java. Please get the basic Java core and OOP skills first, or you can mark it somewhere in your device to read later`*

______
## What Is Design Pattern?
  - First, let back to the past, when programming is only inceptive structure. Our forerunners in the profession has developed the typical app several time, based on Object-Oriented programming languages. 
They __meet the same problem__,__follow a conception__ and __work in the same solution__.

    But noone make it more __architectural__ and aggregate these solutions, or make it more 'easy-access' for other junior. 
    
    So, the software development process often extended
    caused many negative impacts:
>   - Consuming a lot of time, effort and money of customers, reducing the credibility of the business
>   - Decreasing the product lifespan
>   - Easy lead to potential vulnerabilities or overlooked issues
>   - Make difficulties in maintaining and upgrading the project in the future
>   - Causing challenges for developers to unify common conventions.

  - Over time, Libraries and frameworks appeared, supported much for making faster software development process and went a long towards a development model where we can just pick and choose componets and plug them right in. 
    
    But... they don't help us structure our own applications in ways that are easier to understand, more maintainable and flexible. That’s where Design Patterns come in. 

-   In  1995, there are 4 senior developers who aggregate and write to the [Design Patterns: Elements Of Reusable Object-Oriented Software]("http://www.amazon.co.uk/Design-patterns-elements-reusable-object-oriented/dp/0201633612") - the "bible" of many software developer over time (The authors is call `"Gang of Four"`). This book has architect 23 "forms" for developers to structure classes and objects to
solve certain problems in many OOP languages. It encouraged the software engineers should study and structure the product in a more effective way. Some language's corporations like Oracle (Java) and Microsoft (C#) on supporting a lot of features for their language to conform with these "forms".

    These "forms" is called "design pattern" - which we will explore today.
    
______
## Characterists of Design Patterns

- Like data structures and algorithms, it isn't in a special programming language , but it can implement easiest and powerest in the OO programming language (general and pure like Java, C# or support for OOP like Python, C++, JavaScript). 

  `Each design patterns just is the pattern for one or some problem which it can solve effectively.`

___
`Definition`: 

In software engineering, a `design pattern` is a general repeatable solution to a commonly occurring problem in software design. It offer a best practice approach to support object-oriented software design, which is easier to design, implement, change, test and reuse.
____
## How's a Design Pattern structured?
- Each design pattern solve it's problem, and base on the problem, it suggest one or more design pattern which is  suitable and approciated (in both conception and implementation).
- Best practices of exploring Design Patterns is follow 3 issue of this design pattern : 
> + Problem : "What's it solve?"
> + UML     : "How's it solve?"
> + Code example : "How to implement it?"

___
## Types of Design Patterns
- Here is my essay's content about the 5 most popular design patterns which I explored (I divided it into 3 groups by its type).

#### Creational Patterns
> - [Singleton](/Singleton.md)
> - [Factory Method](/Factory.md)
> - Abtract Factory
> - Builder
> - Prototype
#### Structural Patterns
> - Adapter
> - [Facade]()
> - Decorator
> - Flyweight
> - Proxy
> - Composite
> - Bridge
#### Behavior Patterns
> - Interpreter
> - Template Method
> - Chain of Responsibility
> - Command
> - Iterator
> - Mediator
> - Memento
> - [Observer]()
> - Stategy
> - State
> - Visitor

___
## Benefit of using Design Paterns
- It help you solve the problem you meet effectively.
- Improve your code Your code can be more reusable and easier to scale up whenever the project / product extend. In addition, it can improves your code's readability and maintainability.
- Less errors and less costing time for test
Design pattern help us to void potential problem, fallibility by using tested, proven development paradigms (Not to "Reinvent the wheel")
- Better communitcation
DP provide developers the easier way to communicate about problems.

   If used well, DP can speed up your development process and reduce the chance of errors.

____
## Cristicism of using Design Patterns
- Target wrong problem. Some developer desmonstrate that 16/23 design pattern can be eliminated in some other programming language, which can help developer avoid to "choose" wrong solution.
- Require extensive knowledge
Conquering design pattern is need more time to deep into, both the time for learning the OO programming language. It consume a large space for concepts inside the programmer’s head.
- Limit creativity and the power of programming language Because of the "path thinking" whenever meet a problem solved before and use it anytime, you may limit your innovation and cannot use programming language's features in the effectest way. You will scare to try another technology, no hope when move language or try a new and high risk way to solve the problem.
- Lack of formal foundations
It is the experience of software developers, not the study in "ad hoc" way of computer scientists. In 1999, Gang of Four were "charged" by numberous computer scientist, architecture,... in OOPSLA show trial.
- Differ unsignificantly from other abstractions
The MVC , MVP and MVVM are use the same logic for implementation, just "rewrite" some feature in a layer. Used by several year, if you expect a new architecture will make "big update" in these, it wont't be possible, at least for now. The "path thinking" make both us and big corperation can't leave the shadow of safety and laziness.

*For more information, please research about the `anti-patterns` - which is the pattern that opposite the standard design pattern, developed by most scientist and high-experience engineers.*

__Despite of some cristicism, desgin patterns have contributed a lot to the Software Engineering's history, so I recommend you shoud learn it if you want to become a better engineer.__

___
`Special` :  
[Architecture Pattern](/mvc/WhatDiffer.md)

___
## References
> - [Dzone blog](https://dzone.com/articles/what-is-design-pattern)
> - [Redgate forum](https://www.red-gate.com/simple-talk/blogs/why-following-design-patterns-is-a-bad-idea/)
> - [SourceMaking](https://sourcemaking.com/design_patterns)

___
## What's the worst issue junior usually meet when learn how to use it?
- Learn quickly, learrn fast, not learn deep.
It result to the "target wrong problem" and can cause other impacts. 
- Design Patterns is divided into layers, based on **level of problem** which you meet (medium, difficult), not on the **coding level** you have. So, please don't use them for show off your coding skill by using so many design patterns into a project. It may cause many opposite effects and bad affects to your work.

*REMEMBER : **Design patterns are created to solve the complex problem, not to make the problem more complex.***



_**QUOTE**_
```
- When we haven't studied the religion, we see mountains as mountains,  rivers as rivers. 
- When we first learn the religion, we see that mountains are not mountains, rivers are not rivers. 
- After studying the religion, we see that mountains are just rivers, rivers are just rivers.
```