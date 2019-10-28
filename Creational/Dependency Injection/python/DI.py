import sys

class Fuel(object):
    ''' Base class Fuel   '''


'''Child class Petrol'''
class Petrol(Fuel):

    def __init__(self):
        print("Fuel used is petrol")

''' Child class Diesel '''
class Diesel(Fuel):

    def __init__(self):
        print("Fuel used is diesel")


''' Child class Electricity '''
class Electricity(Fuel):

    def __init__(self):
        print("Fuel used is electricity")


class Car(object):
    """Example car."""

    def __init__(self, fuel):
        """Initializer."""
        self._fuel = fuel  # Fuel is injected


if __name__ == '__main__':

#We can create cars using any fuel for injection
    petrol = Petrol()
    petrol_car = Car(petrol)

    diesel = Diesel()
    diesel_car =   Car(diesel)

    electricity = Electricity()
    electric_car = Car(electricity)