package com.mycompany.strategy_arithmetical_operations;

// Context: Represents the arithmetic calculator
public class CalculatorContext {

    private Strategy strategy;

    // Set the strategy dynamically
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Execute the selected strategy
    public int executeStrategy(int a, int b) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set.");
        }
        return strategy.execute(a, b);
    }
}
