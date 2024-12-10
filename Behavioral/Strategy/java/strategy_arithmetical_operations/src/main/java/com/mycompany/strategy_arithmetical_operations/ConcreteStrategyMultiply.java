package com.mycompany.strategy_arithmetical_operations;

// Concrete Strategy for Multiplication
public class ConcreteStrategyMultiply implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a * b;
    }

}
