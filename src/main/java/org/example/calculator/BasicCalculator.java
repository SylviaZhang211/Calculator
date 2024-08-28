package org.example.calculator;

import org.example.calculator.strategies.AddOperation;
import org.example.calculator.strategies.DivideOperation;
import org.example.calculator.strategies.MultiplyOperation;
import org.example.calculator.strategies.SubtractOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic calculator implementation that supports different operations.
 */
public class BasicCalculator implements Calculator {

    private final Map<Operation, OperationStrategy> strategies = new HashMap<>();

    public BasicCalculator() {
        strategies.put(Operation.ADD, new AddOperation());
        strategies.put(Operation.SUBTRACT, new SubtractOperation());
        strategies.put(Operation.MULTIPLY, new MultiplyOperation());
        strategies.put(Operation.DIVIDE, new DivideOperation());
    }

    public void addStrategy(Operation operation, OperationStrategy strategy) {
        strategies.put(operation, strategy);
    }

    @Override
    public Number calculate(Operation op, Number num1, Number num2) {
        OperationStrategy strategy = strategies.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        return strategy.execute(num1, num2);
    }

    @Override
    public Number chainCalculate(Number initial, Object[][] operations) {
        Number result = initial;
        for (Object[] operation : operations) {
            Operation op = (Operation) operation[0];
            Number num = (Number) operation[1];
            result = calculate(op, result, num);
        }
        return result;
    }
}
