from abc import ABC, abstractmethod


class Element(ABC):

    @abstractmethod
    def accept(self, visitor):
        pass


class Visitor(ABC):

    @abstractmethod
    def visist_a(self, element_a):
        pass

    @abstractmethod
    def visist_b(self, element_b):
        pass


class ElementA(Element):

    def accept(self, visitor: Visitor):
        visitor.visist_a(self)

    def feature_a(self):
        return "Feature of Element A"


class ElementB(Element):

    def accept(self, visitor: Visitor):
        visitor.visist_b(self)

    def feature_b(self):
        return "Feature of Element B"


class ConcreteVisitorAlpha(Visitor):

    def visist_a(self, element_a: ElementA):
        print("Concrete Visitor Alpha visiting %s" % element_a.feature_a())

    def visist_b(self, element_b: ElementB):
        print("Concrete Visitor Alpha visiting %s" % element_b.feature_b())


class ConcreteVisitorBeta(Visitor):

    def visist_a(self, element_a: ElementA):
        print("Concrete Visitor Beta visiting %s" % element_a.feature_a())

    def visist_b(self, element_b: ElementB):
        print("Concrete Visitor Beta visiting %s" % element_b.feature_b())


def main():
    elements = [ElementA(), ElementB()]
    visitors = [ConcreteVisitorAlpha(), ConcreteVisitorBeta()]

    for element in elements:
        for visitor in visitors:
            element.accept(visitor)


if __name__ == "__main__":
    main()
