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

        Number chainResult = calculator.chainCalculate(10, operations);
        System.out.println("Result of chained operations: " + chainResult); // Output: 25
    }
}
