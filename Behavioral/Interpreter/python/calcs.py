from operations import Number, Sum, Subtraction, Multiplication, Division


if __name__ == '__main__':
    five_minus_three = Subtraction(Number(5), Number(3))
    three_plus_six = Sum(Number(3), Number(6))
    
    complex_expression = Multiplication(five_minus_three, three_plus_six)

    final_expression = Division(complex_expression, Number(2))
    
    print(f'((5 - 3) * (3 + 6)) / 2 = {final_expression.evaluate()}')
