from abc import ABC, abstractmethod


class Creator(ABC):

    def some_operation(self):
        product = self.create_product()
        product.do_stuff()

    @abstractmethod
    def create_product(self):
        pass


class Product(ABC):

    @abstractmethod
    def do_stuff(self):
        pass


class ConcreteProductAlpha(Product):

    def do_stuff(self):
        print("Stuff of product Alpha")


class ConcreteCreatorAlpha(Creator):

    def create_product(self):
        return ConcreteProductAlpha()


class ConcreteProductBeta(Product):

    def do_stuff(self):
        print("Stuff of product Beta")


class ConcreteCreatorBeta(Creator):

    def create_product(self):
        return ConcreteProductBeta()


def main():
    creatorAlpha = ConcreteCreatorAlpha()
    creatorAlpha.some_operation()

    creatorBeta = ConcreteCreatorBeta()
    creatorBeta.some_operation()


if __name__ == "__main__":
    main()
