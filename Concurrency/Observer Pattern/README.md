##### What is the Observer Pattern?
The observer pattern is a software design pattern in which an object, called the subject,
maintains a list of its dependents, called observers, and notifies them automatically
of any state changes, usually by calling one of their methods.

The observer pattern solves a fairly common problem: What if a group of objects
needs to update themselves when some object changes state? This can be seen in the “model-view”
aspect of Smalltalk’s MVC (model-view-controller), or the almost-equivalent “Document-View Architecture.” 
Suppose that you have some data (the “document”) and more than one view, say a plot and a textual view. 
When you change the data, the two views must know to update themselves, and that’s what the observer facilitates. 
It’s a common enough problem that its solution has been made a part of the standard java.util library.

![Oberserver Pattern UML Class Diagram](https://www.uml-diagrams.org/examples/composite-structure-example-observer-composite.png "Logo Title Text 1")

