# Method Chaining

It consist in calling modifier methods on a single line, 'chaining' them together with a dot (.). To make this possible, the modifier methods should return the host object itself (or another instance of the same class). A class whose modifier methods are chainable is said to be implementing a *Fluent Interface*.

## Purpose

*Method Chaining* avoids the burden of instantiating a different, extra variable in case different methods should be invoked subsequently on the same object. Invoking a method after another produces a more compact code, but a careless use of this pattern may make the code harder to understand, and can make the debugging process more difficult.

## Examples

**Builder** design pattern makes use of method chaining in providing a cleaner and more concise way to build an object.