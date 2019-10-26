# Visitor

> Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate.

The visitor design pattern is a way of separating an algorithm from an object structure on which it operates. 
A practical result of this separation is the ability to add new operations to existing object structures without modifying the structures.
It is one way to follow the open/closed principle.
In essence, the visitor allows adding new virtual functions to a family of classes, without modifying the classes.
Instead, a visitor class is created that implements all of the appropriate specializations of the virtual function.
The visitor takes the instance reference as input, and implements the goal through double dispatch.

More information and use cases can be found on the following pages: 
 * [Visitor - Refactoring Guru](https://refactoring.guru/design-patterns/visitor)
 * [Visitor - Vince Houston](http://www.vincehuston.org/dp/visitor.html)
