package org.example.calculator;


import java.util.ArrayList;
import java.util.List;

public class ChainCalculatorBuilder {

    private Number initialValue;
    private final List<Object[]> operations;

    public ChainCalculatorBuilder() {
        this.operations = new ArrayList<>();
    }

    /**
     * Sets the initial value for the calculation.
     *
     * @param initialValue The initial value.
     * @return The builder instance for method chaining.
     */
    public ChainCalculatorBuilder setInitValue(Number initialValue) {
        this.initialValue = initialValue;
        return this;
    }

    /**
     * Adds an operation to be performed in the chain.
     *
     * @param operation The operation strategy to use.
     * @param value     The value to apply the operation with.
     * @return The builder instance for method chaining.
     */
    public ChainCalculatorBuilder addOperation(OperationStrategy operation, Number value) {
        this.operations.add(new Object[]{operation, value});
        return this;
    }

    /**
     * Calculates the result of the chain of operations.
     *
     * @return The final result after all operations are applied.
     */
    public Number calculate() {
        BasicCalculator calculator = new BasicCalculator();
        return calculator.chainCalculate(initialValue, operations);
    }
}

