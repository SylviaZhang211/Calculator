package org.example.calculator;

import java.util.List;
import org.example.calculator.exceptions.UnsupportedOperationException;

/**
 * Basic calculator implementation that supports different operations.
 */
public class BasicCalculator implements Calculator {

    private final OperationStrategyFactory strategyFactory;

    public BasicCalculator() {
        this.strategyFactory = OperationStrategyFactory.getInstance();
    }

    /**
     * Calculates the result of an operation between two numbers.
     *
     * @param op The operation to perform (e.g., ADD, SUBTRACT).
     * @param num1      The first number.
     * @param num2      The second number.
     * @return The result of the operation.
     */
    @Override
    public Number calculate(OperationStrategy op, Number num1, Number num2) {
        if (op == null) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        OperationStrategy strategy = strategyFactory.getStrategy(op);

        return strategy.execute(num1, num2);
    }

    /**
     * Calculates the result of a chain of operations starting from an initial value.
     *
     * @param initial    The initial value.
     * @param operations An array of operations to perform sequentially.
     * @return The final result after all operations are applied.
     */
    @Override
    public Number chainCalculate(Number initial, Object[][] operations) {
        Number result = initial;
        for (Object[] operation : operations) {
            OperationStrategy op = (OperationStrategy) operation[0];
            Number num = (Number) operation[1];
            result = calculate(op, result, num);
        }
        return result;
    }

    /**
     * Calculates the result of a chain of operations starting from an initial value.
     *
     * @param initial    The initial value.
     * @param operations A list of operations to perform sequentially.
     * @return The final result after all operations are applied.
     */
    public Number chainCalculate(Number initial, List<Object[]> operations) {
        Number result = initial;
        for (Object[] operation : operations) {
            OperationStrategy op = (OperationStrategy) operation[0];
            Number num = (Number) operation[1];
            result = calculate(op, result, num);
        }
        return result;
    }
}
