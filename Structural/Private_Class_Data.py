/* A class may expose its attributes (class variables) to manipulation when manipulation is no longer desirable,
e.g. after construction. Using the private class data design pattern prevents that undesirable manipulation.
A class may have one-time mutable attributes that cannot be declared final.
Using this design pattern allows one-time setting of those class attributes.
The motivation for this design pattern comes from the design goal of protecting class state by minimizing
the visibility of its attributes (data). */
//CODE:
    
class DataClass:
    """
    Hide all the attributes.
    """

    def __init__(self):
        self.value = None

    def __get__(self, instance, owner):
        return self.value

    def __set__(self, instance, value):
        if self.value is None:
            self.value = value


class MainClass:
    """
    Initialize data class through the data class's constructor.
    """

    attribute = DataClass()

    def __init__(self, value):
        self.attribute = value


def main():
    m = MainClass(True)
    m.attribute = False


if __name__ == "__main__":
    main()
