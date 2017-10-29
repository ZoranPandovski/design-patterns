# FACADE DESIGN PATTERN

> The facade (aka façade) design pattern hides the complexities of a system by providing a simple interface that can be used by a client to access a system

By hiding the complexity of a system, this design pattern allows for a better code readability as well as reducing the dependencies
of external code on the inner parts of a library, because the most part of the code uses the facade to access those inner parts.

The facade design pattern uses the interface methods to delegate functions to the more complex methods that are part of the system
implementation, which remain hidden for outside code (normally the client code).
