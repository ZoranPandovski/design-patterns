# Private Class Data

A class may expose its attributes (class variables) to manipulation when manipulation is no longer desirable,
e.g. after construction. Using the private class data design pattern prevents that undesirable manipulation.
A class may have one-time mutable attributes that cannot be declared final.
Using this design pattern allows one-time setting of those class attributes.
The motivation for this design pattern comes from the design goal of protecting class state by minimizing
the visibility of its attributes (data).