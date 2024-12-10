package com.mycompany.strategy_arithmetical_operations;

// Client: Demonstrates the use of the Strategy pattern
public class CalculatorClient {
    public static void calculatorClient(){
        CalculatorContext calculator = new CalculatorContext();

        int firstNumber = 10;
        int secondNumber = 5;

        // Perform Addition
        calculator.setStrategy(new ConcreteStrategyAdd());
        System.out.println("Addition: " + calculator.executeStrategy(firstNumber, secondNumber));

        // Perform Subtraction
        calculator.setStrategy(new ConcreteStrategySubstract());
        System.out.println("Subtraction: " + calculator.executeStrategy(firstNumber, secondNumber));

        // Perform Multiplication
        calculator.setStrategy(new ConcreteStrategyMultiply());
        System.out.println("Multiplication: " + calculator.executeStrategy(firstNumber, secondNumber));
    }
}
