# Delegation Pattern

---

![Delegation](http://best-practice-software-engineering.ifs.tuwien.ac.at/patterns/images/Delegation.jpg)

It is a technique where an object expresses certain behavior to the outside but in reality delegates responsibility for implementing that behaviour to an associated object. This sounds at first very similar to the proxy pattern, but it serves a much different purpose. Delegation is an abstraction mechanism which centralizes object (method) behaviour.

The diagram above shows how multiple-inheritance behavior can be accomplished in Java for actual classes. Of course delegation is not limited to scenarios where multiple-inheritance has to be avoided (as Java does not support this), but can be seen in general as an alternative to inheritance. The same functionality can also be accomplished with interfaces, however sometimes the relationship you want between two classes is actually one of containment rather than inheritance.


### Applicability / Uses


Use the delegation pattern when:

you need to reduce the coupling of methods to their class
you have components that behave identically, but realize that this situation can change in the future.
Generally spoken: use delegation as alternative to inheritance. Inheritance is a good strategy, when a close relationship exist in between parent and child object, however, inheritance couples objects very closely. Often, delegation is the more flexible way to express a relationship between classes.

This pattern is also known as "proxy chains". Several other design patterns use delegation - the State, Strategy and Visitor Patterns depend on it.

---


*[Lecture slides of course 601: "Object-Oriented Software Development" at the University of San Francisco ]*
