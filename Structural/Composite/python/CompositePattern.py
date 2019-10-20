from abc import ABC, abstractmethod


class Component(ABC):

    @property
    def parent(self):
        return self._parent

    @parent.setter
    def parent(self, parent):
        self._parent = parent

    @parent.deleter
    def parent(self):
        self._parent = None

    @abstractmethod
    def operation(self):
        pass

    def add(self, component):
        pass

    def remove(self, component):
        pass


class AlphaLeaf(Component):

    def operation(self):
        return 1


class BetaLeaf(Component):

    def operation(self):
        return 2


class GammaLeaf(Component):

    def operation(self):
        return 3


class Composite(Component):

    def __init__(self) -> None:
        self._children = []

    def add(self, component):
        del component.parent
        self._children.append(component)

    def remove(self, component):
        component.parent = self
        self._children.remove(component)

    def operation(self):
        return sum([x.operation() for x in self._children])


def main():
    composite = Composite()
    branch_a = Composite()
    branch_b = Composite()
    branch_b_a = Composite()

    composite.add(AlphaLeaf())

    alpha_leaf = AlphaLeaf()
    branch_a.add(alpha_leaf)
    branch_a.add(BetaLeaf())

    branch_b.add(GammaLeaf())

    branch_b_a.add(AlphaLeaf())
    branch_b_a.add(BetaLeaf())

    composite.add(branch_a)
    composite.add(branch_b)
    branch_b.add(branch_b_a)

    print("Total: %d" % composite.operation())

    branch_a.remove(alpha_leaf)

    print("Total: %d" % composite.operation())


if __name__ == "__main__":
    main()
