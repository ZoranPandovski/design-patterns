class Person:
    def __init__(self, builder):
        """ constructor """
        self.firstName = builder.firstName
        self.lastName = builder.lastName

    def getFirstName(self):
        return self.firstName

    def getLastName(self):
        return self.lastName

    @staticmethod
    def getBuilder():
        return _Builder()

class _Builder:
    """
    Beginning underscore signifies the Builder class is private.
    """
    def firstName(self, firstName):
        self.firstName = firstName
        return self

    def lastName(self, lastName):
        self.lastName = lastName
        return self

    def build(self):
        return Person(self)

if __name__ == '__main__':
    person = Person.getBuilder().firstName("John").lastName("Doe").build()
    print(person.getFirstName() + " " + person.getLastName())
