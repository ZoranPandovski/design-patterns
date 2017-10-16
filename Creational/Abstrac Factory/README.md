# Factory Pattern

> Abstract the logic of object creation by delegating this responsibility to a factory class that can supply objects of various types based on provided input parameters.

This pattern is commonly used to promote loose coupling of code with regard to the creation of objects. When another class requests a new object from a factory, it does not need to be aware of _how_ that object is created, it only needs to request the new object. As an additional benefit, the requesting class doesn't even need to be know about the exact class that is provided by the factory; it just needs to know about the supertype or interface that the factory provides.

For more information, Wikipedia provides a great overview of the pattern: [Wikipedia Article](https://en.wikipedia.org/wiki/Factory_method_pattern)