package org.example.calculator;

public interface Calculator {
    Number calculate(OperationStrategy op, Number num1, Number num2);
    Number chainCalculate(Number initial, Object[][] operations);
}
