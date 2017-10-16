# Strategy Pattern

> Defer the selection of algorithms until runtime.

This pattern is commonly used to promote flexible and reusable code by deferring the selection of algorithms to runtime. Rather than implementing algorithms directly within a class, using an interface with multiple implementations leads to the ability to quickly change implementation details as requirements change and make decisions about algorithm usage based on application state.

For more information, Wikipedia provides a great overview of the pattern: [Wikipedia Article](https://en.wikipedia.org/wiki/Strategy_pattern)