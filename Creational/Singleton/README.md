# Singleton Pattern

> Guarantee that there is only one instance of the _singleton_ object within an application.

This pattern is commonly used to ensure that only one instance of the particular object exists in memory. This is particularly useful for objects that coordinate access to shared resources such as data stores.

## Disadvantages

Despite being one of the most frequently used design patterns, Singleton presents some disadvantages. 

### Testing

Singletons can make unit testing harder. Classes that depend on a Singleton are very hard to isolate: this means that when testing a class that depends on a Singleton, it's easy to end up testing the Singleton as well. More on this can be found in this talk by Miško Hevery[The Clean Code Talks - Global State and Singletons](https://www.youtube.com/watch?v=-FRm3VPhseI)

For more information, Wikipedia provides a great overview of the pattern: [Wikipedia Article](https://en.wikipedia.org/wiki/Singleton_pattern)