package com.mycompany.strategy_arithmetical_operations;

// Concrete Strategy for Substraction
public class ConcreteStrategySubstract implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a - b;
    }

}
