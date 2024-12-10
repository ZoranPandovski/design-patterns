# Strategy Pattern

This design pattern is especially powerful in scenarios where multiple algorithms need to coexist and be interchangeable at runtime without modifying the core business logic.

## Strategy Pattern for Arithmetic Operations
> This example of the Strategy Pattern demonstrates how algorithms for addition, subtraction, and multiplication are encapsulated in separate strategy classes. The CalculatorContext class delegates the execution to a Strategy instance via polymorphism, enabling dynamic behavior selection at runtime. This approach simplifies adding new algorithms and keeps the design flexible, scalable, and maintainable..

<p align="center">
  <img src="../images/strategy_pattern.png" width="878" height="582" alt="Strategy pattern - Diagram of classes, this diagram was generated with https://app.diagrams.net/">
</p>

<p align="center">

<p align="center">
  <em>Fig 1: Strategy pattern - Diagram of classes, this diagram was generated with https://app.diagrams.net/</em>
</p>

**RelationShips**

**1. Interface Implementation:**

- AdditionStrategy, SubstractionStrategy, and MultiplicationStrategy implement the Strategy interface, showcasing a polymorphic relationship.

**2. Aggregation:**

- CalculatorContext has an aggregation relationship with the Strategy interface because it holds a reference to a Strategy instance but does not own it permanently.

**3. Dependency:**

- The CalculatorClient depends on CalculatorContext and concrete strategies (AdditionStrategy, SubstractionStrategy, and MultiplicationStrategy) to fulfill its operations.

**Key Points**

**1. Polymorphism via the Interface:**

- The `Strategy` interface defines the `execute` method that all concrete strategy classes (`AdditionStrategy`, `SubstractionStrategy`, `MultiplicationStrategy`) implement.
- Since `strategy` is declared as type `Strategy` in the `CalculatorContext` class, it can hold a reference to any object that implements the `Strategy` interface.
- This allows the `executeStrategy` method to call the `execute` method on the `strategy` instance without knowing its exact type, relying purely on the interface.

**2. Decoupling the CalculatorContext from the Concrete Strategies:**

- The `executeStrategy` method doesn't need to know which specific algorithm (e.g., addition, subtraction, or multiplication) is being executed.
- This responsibility is shifted to the `strategy` instance, which is set dynamically at runtime via the `setStrategy` method.

**3. Flexibility and Scalability:**

- Flexibility: You can change the behavior of the `executeStrategy` method at runtime by providing a different strategy instance.
- Scalability: Adding new strategies (e.g., division or exponentiation) is straightforward. You simply create a new class implementing the `Strategy` interface without modifying the existing code in the `CalculatorContext` or `executeStrategy` method. This adheres to the **Open/Closed Principle** of SOLID design principles.