#interface
class ICalculator:
    def Add():
        pass

#subject
class Calculator(ICalculator):
    def Add(self, First, Second):
        return First + Second

#proxy
class CalculatorProxy(ICalculator):

    def __init__(self):
        self.calculator = Calculator()
    
    def Add(self, First, Second):
        #method in base class automatically overriden
        print("Calculating...")
        result = str(First) + " + " + str(Second) + " = " + str(self.calculator.Add(First, Second))
        return result

#instance of proxy
calc = CalculatorProxy()

print(calc.Add(3,4))
