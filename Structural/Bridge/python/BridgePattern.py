from abc import ABC, abstractmethod

class Implementation(ABC):

    @abstractmethod
    def operation_a(self) -> str:
        pass
    
    @abstractmethod
    def operation_b(self, num: int):
        pass

class Abstraction:

    def __init__(self, implementation: Implementation):
        self.implementation = implementation
    
    def operation_one(self):
        self.implementation.operation_a()
        self.implementation.operation_b(1)
    
    def operation_two(self):
        self.implementation.operation_a()
    

class ConcreteImplementationAlpha(Implementation):

    def operation_a(self) -> str:
        print("Alpha a")
    
    def operation_b(self, num: int):
        print("Alpha b {0}".format(num))

class ConcreteImplementationBetha(Implementation):

    def operation_a(self) -> str:
        print("Betha a")
    
    def operation_b(self, num: int):
        print("Betha b {0}".format(num))

class ExtendedAbstraction(Abstraction):

    def operation_tree(self):
        self.implementation.operation_b(2)

def main():
    abstractions = [Abstraction(ConcreteImplementationAlpha()), 
    Abstraction(ConcreteImplementationBetha())]

    for abstraction in abstractions:
        abstraction.operation_one()


if __name__ == "__main__":
    main() 
