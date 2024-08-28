package org.example.calculator.strategies;

import org.example.calculator.OperationStrategy;

/**
 * Strategy for subtraction operation.
 */
public class SubtractOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
