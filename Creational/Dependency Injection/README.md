# Dependency Injection

> Dependency Injection (DI) is a design pattern that demonstrates how to create loosely coupled classes.

Dependency injection is a technique whereby one object supplies the dependencies of another object. A dependency is an object that can be used (a service). An injection is the passing of a dependency to a dependent object (a client/consumer) that would use it. The service is made part of the client's state. Passing the service to the client, rather than allowing a client to build or find the service, is the fundamental requirement of the pattern.

## The Dependency Injection design pattern solves problems like:

 - How can an application be independent of how its objects are created?
 - How can a class be independent of how the objects it requires are created?
 - How can the way objects are created be specified in separate configuration files?
 - How can an application support different configurations?

## Benefits of Dependency Injection

Some of the benefits of using Dependency Injection in Java are:

 - Separation of Concerns
 - Boilerplate Code reduction in application classes because all work to initialize dependencies is handled by the injector component
 - Configurable components makes application easily extendable
 - Unit testing is easy with mock objects

## Disadvantages of Dependency Injection

Dependency injection has some disadvantages too:

 - If overused, it can lead to maintenance issues because effect of changes are known at runtime.
 - Dependency injection in java hides the service class dependencies that can lead to runtime errors that would have been caught at compile time.

For more information, Wikipedia provides a great overview of the pattern: [Wikipedia Article](https://en.wikipedia.org/wiki/Dependency_injection)