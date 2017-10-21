Template Method Pattern

Provides a solution for a problem when an algorithm consists of customizable parts and invariant parts
It allows you to implement invariant parts of the algorithm in an abstract class with abstract (unimplemented) primitive
operations representing the customizable parts of the algorithm. The subclasses customize the primitive operations

Consequences:
Code reuse for the invariant parts of algorithm
Customization is restricted to the primitive operations
Inverted control for customization