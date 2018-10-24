# Mediator

Defines an object that encapsulates the way a set of objects interacts. The mediator promotes loose coupling by preventing objects from explicitly referencing each other, and allows you to vary their interaction independently.

# When use it

Different objects have interactions. An event on one causes an action or actions on another or other objects.

It can be HMI Components. For example, a click on a checkbox or a button can change the color or the visibility of some field. 

If the classes communicate directly, there is a hard link between them. A dedicated class can avoid this. This class is called a mediator

# Participants

The 3 classes in this design pattern are :


- **Mediator** 
  - Defines an interface for communicating with Colleague objects
  
- **ConcreteMediator **
  - Implements cooperative behavior by coordinating  
  Colleague objects
  - Knows and maintains its colleagues

- **Colleague classes**
  - Each Colleague class knows its Mediator object
  - Each colleague communicates with its mediator whenever it would have otherwise communicated with another colleague