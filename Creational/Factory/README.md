# Factory

Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.

In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.

The benefit of the Factory pattern is that it isolates change to a single point in the application. If new sub-classes are added only the factory method needs to be updated. If a class implementation is changed, as long as the interface is consistent the factory will still work because the implementation is encapsulated from the factory.

Use caution when using the Factory pattern as code can become tightly coupled between application layers, and the number of classes and abstractions can increase. As with any design pattern, use with discretion.

Text and Java code used can be found in [Tutorials Point WebSite](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
