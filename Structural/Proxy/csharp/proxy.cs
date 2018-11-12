using System;

class Program
{
    static void Main(string[] args)
    {
        CalculatorProxy calc = new CalculatorProxy();
        Console.WriteLine(calc.Add(5,6));
        Console.ReadKey();
    }
}


//interface
public interface ICalculator
{
    int Add(int a, int b);
}

//subject
public class Calculator : ICalculator
{
    public int Add(int a, int b)
    {
        return a + b;
    }
}

//proxy
public class CalculatorProxy : ICalculator
{
    //an instance of subject
    private ICalculator _calculator;

    public int Add(int a, int b)
    {
        if (_calculator == null)
        {
            _calculator = new Calculator();
        }

        // do any extra stuff here
        return _calculator.Add(a, b);
    }
}
