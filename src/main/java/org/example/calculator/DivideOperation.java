package org.example.calculator;

public class DivideOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}
