package com.mycompany.strategy_arithmetical_operations;

// Concrete Strategy for Addition
public class ConcreteStrategyAdd implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }

}
