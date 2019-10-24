from abc import ABC, abstractmethod


class OperationBase(ABC):
    def __init__(self, left_expresion, right_expression):
        self._left_expresion = left_expresion
        self._right_expression = right_expression
    
    @abstractmethod
    def evaluate(self):
        pass


class Sum(OperationBase):
    def evaluate(self):
        return self._left_expresion.evaluate() + self._right_expression.evaluate()


class Subtraction(OperationBase):
    def evaluate(self):
        return self._left_expresion.evaluate() - self._right_expression.evaluate()


class Multiplication(OperationBase):
    def evaluate(self):
        return self._left_expresion.evaluate() * self._right_expression.evaluate()


class Division(OperationBase):
    def evaluate(self):
        right_expression_value = self._right_expression.evaluate()
        if right_expression_value == 0:
            raise Exception('Division by 0 is not suported')
        return self._left_expresion.evaluate() / self._right_expression.evaluate()


class Number:
    def __init__(self, number):
        self._number = number
    
    def evaluate(self):
        return self._number
