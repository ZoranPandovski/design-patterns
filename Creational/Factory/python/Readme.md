### How it Works
Simply put, the Factory Method pattern can be used to create an interface for a method, leaving the implementation to the class that gets
instantiated.

### Usage
Used in most of the pupular web frameworks. In Django, for example, in a contact form of a web page, the subject and the message
fields are created using the same form factory (CharField()), even though they have different implementations according to their purposes.
