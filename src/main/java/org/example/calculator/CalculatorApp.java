package org.example.calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();

        Number result = calculator.calculate(Operation.ADD, 10, 5);
        System.out.println("Result of ADD operation: " + result); // Output: 15

        Object[][] operations = {
                {Operation.ADD, 10},
                {Operation.MULTIPLY, 2},
                {Operation.SUBTRACT, 5}
        };

        OperationStrategy exponentiation = new OperationStrategy() {
            @Override
            public Number execute(Number base, Number exponent) {
                return Math.pow(base.doubleValue(), exponent.doubleValue());
            }
        };

        Number chainResult = calculator.chainCalculate(10, operations);
        System.out.println("Result of chained operations: " + chainResult); // Output: 35
        // Custom operation example
        // Adding the custom operation to the factory
        OperationStrategyFactory.getInstance().addOperation(exponentiation, exponentiation);

        // Test the custom operation individually
        Number exponentiationResult = calculator.calculate(exponentiation, 2, 3);
        System.out.println("Exponentiation Result: " + exponentiationResult);  // Expected Output: 8.0

        // Test the custom operation in a chainCalculate
        Object[][] operations2 = {
                {exponentiation, 3},
                {Operation.MULTIPLY, 10}
        };

        Number chainResult2 = calculator.chainCalculate(2, operations2);
        System.out.println("Chain Result with Exponentiation: " + chainResult2);  // Expected Output: 104.0

        Number builderResult = new ChainCalculatorBuilder()
                .setInitValue(10)
                .addOperation(Operation.ADD, 10)
                .addOperation(exponentiation, 2)
                .addOperation(Operation.MULTIPLY, 2)
                .calculate();

        System.out.println("Final Result using ChainCalculatorBuilder: " + builderResult);

    }

}

