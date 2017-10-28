### How it works 

The Decorator pattern is used to dynamically add a new feature to an object without changing its implementation. 

It differs from inheritance because the new feature is added only to that particular object, not to the entire subclass.

### Usage

In the wild, the Grok framework uses decorators to add functionalities to methods, like permissions.

In the sample code, we  add formatting options (boldface and italic) to a text by appending the corresponding tags (<b> and <i>). 
