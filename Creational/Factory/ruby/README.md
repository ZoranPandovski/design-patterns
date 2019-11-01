# Factory Pattern

This example implements the Factory pattern to hide from the consumer the complexity of initializing different
types of shapes.

Instead it provides a single method to generate random instance of any of given subclasses of `Shape` which then
can be used by the consumer (e.g. to output the properties of the shapes).