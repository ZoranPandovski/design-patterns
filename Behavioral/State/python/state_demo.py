# -*- coding: UTF-8 -*-

from abc import ABCMeta, abstractmethod

class Quotation_state(object, metaclass=ABCMeta):
    @abstractmethod
    def apply_extra_discount(self, quotation):
        pass

    @abstractmethod
    def approve(self, quotation):
        pass

    @abstractmethod
    def deny(self, quotation):
        pass

    @abstractmethod
    def finish(self, quotation):
        pass


class In_approval(Quotation_state):
    def apply_extra_discount(self, quotation):
        quotation.add_extra_discount(quotation.value * 0.05)

    def approve(self, quotation):
        quotation.current_state = Aproved()

    def deny(self, quotation):
        quotation.current_state = Denied()

    def finish(self, quotation):
        raise Exception('Quotation in approval cannot be finished directly')


class Aproved(Quotation_state):
    def apply_extra_discount(self, quotation):
        quotation.add_extra_discount(quotation.value * 0.02)

    def approve(self, quotation):
        raise Exception('Quotation is already in approval state')

    def deny(self, quotation):
        raise Exception('Quotation is already in approval and cannot be denied')

    def finish(self, quotation):
        quotation.current_state = Finished()


class Denied(Quotation_state):
    def apply_extra_discount(self, quotation):
        raise Exception('Denied quotation cannot apply extra discounts')

    def approve(self, quotation):
        raise Exception('Denied quotation cannot be approved')

    def deny(self, quotation):
        raise Exception('Quotation is already in approval state')

    def finish(self, quotation):
        raise Exception('Denied quotation cannot be finished')

class Finished(Quotation_state):
    def apply_extra_discount(self, quotation):
        raise Exception('Finished quotation cannot apply extra discounts')

    def approve(self, quotation):
        raise Exception('Finished quotation cannot be approved')

    def deny(self, quotation):
        raise Exception('Finished quotation cannot be denied')

    def finish(self, quotation):
        raise Exception('Quotation is already finished')


class Quotation(object):

    def __init__(self):
        self.__items = []
        self.current_state = In_approval()
        self.__desconto_extra = 0

    def add_items(self, item):
        self.__items.append(item)

    def apply_extra_discount(self):
        self.current_state.apply_extra_discount(self)

    def add_extra_discount(self, desconto):
        self.__desconto_extra+= desconto

    def approve(self):
        self.current_state.approve(self)

    def deny(self):
        self.current_state.deny(self)

    def finish(self):
        self.current_state.finish(self)

    @property
    def value(self):
        total = 0.0
        for item in self.__items:
            total += item.value
        return total - self.__desconto_extra

class Item(object):

    def __init__(self, name, value):
        self.__name = name
        self.__valor = value

    @property
    def value(self):
        return self.__valor

    @property
    def name(self):
        return self.__name


if __name__ == '__main__':
    quotation = Quotation()
    quotation.add_items(Item('Item A', 100.0))
    quotation.add_items(Item('Item B', 50.0))
    quotation.add_items(Item('Item C', 400.0))

    quotation.apply_extra_discount()
    print(quotation.value) # print 522.5 applying 5% discount on 550.0
    quotation.approve()

    quotation.apply_extra_discount()
    print(quotation.value) # print 512.05 applying 2% discount on 522.5
    quotation.finish()

    quotation.apply_extra_discount() # throws exception, cannot apply discount on a finished quotation