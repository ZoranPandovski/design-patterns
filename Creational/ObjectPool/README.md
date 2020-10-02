# Object Pool

It consist in keeping a 'pool' of already initialized objects, from which they can be acquired and to which they should be released after usage, instead of being destroyed.

## Purpose

*Object Pool* pattern is very useful in some common situations:
- When instantiating (and deallocating) and object is an expensive operation that is impacting performances,
- When only a fixed number of objects of a certain kind should exist in the system: if all of them are busy, when an object is request from the pool the thread should wait for one of the already instantiated objects to be free (or throw some kind of exception). 

## Examples

### Connection Pools
One of the most common scenarios in which the Object Pool pattern is useful is the *Connection Pool* scenario. In this case, the objects in the pool hold a reference to an external resource. In this case, both of the advantages of pooling are met: it is easy to control the number of connections, that cannot increase indefinitely, and the connection creation phase is executed just once.

### Memory Pools
Those are frequent especially in languages in which there is no garbage collection (like C) and in high-performance real time scenario that would require continuous dynamic memory allocation: it is more performant and efficient to preallocate memory blocks that can be accessed and used by the application without the burden of allocating them and the risk of incurring in memory fragmentation.