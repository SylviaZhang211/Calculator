# Basic Calculator with Custom Operations

## Overview

This project implements a simple, extensible calculator in Java that supports basic arithmetic operations as well as custom operations. The calculator adheres to object-oriented principles, particularly the Open-Closed Principle, allowing new operations to be added without modifying the existing code. The project includes unit tests to ensure correctness, including edge cases and custom operations.

## Features

- **Basic Operations**: Supports addition, subtraction, multiplication, and division.
- **Custom Operations**: Easily extend the calculator with custom operations (e.g., exponentiation).
- **Chaining Calculations**: Perform a sequence of operations in a single calculation. Chaining calculations is realized by two means:
  1. Directly in the `BasicCalculator` class using an array of operations.
  2. Using a `ChainCalculatorBuilder` for a fluent and flexible chaining API.
- **Error Handling**: Graceful handling of division by zero and unsupported operations.
- **Test Coverage**: Comprehensive unit tests for both basic and custom operations.


## Getting Started

### Prerequisites

- Java 8 or later
- Maven (optional, for building and running tests)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/basic-calculator.git
    cd basic-calculator
    ```

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build the project using Maven (if needed):
    ```bash
    mvn clean install
    ```

### Usage

To use the `BasicCalculator`:

1. **Perform Basic Operations**:
    ```java
    Calculator calculator = new BasicCalculator();
    Number result = calculator.calculate(Operation.ADD, 10, 5);
    System.out.println(result); // Outputs: 15.0
    ```

2. **Add a Custom Operation**:
    ```java
    OperationStrategy exponentiation = new OperationStrategy() {
        @Override
        public Number execute(Number base, Number exponent) {
            return Math.pow(base.doubleValue(), exponent.doubleValue());
        }
    };

    OperationStrategyFactory.getInstance().addOperation(exponentiation, exponentiation);
    Number result = calculator.calculate(exponentiation, 2, 3);
    System.out.println(result); // Outputs: 8.0
    ```

   3. **Chain Multiple Operations**:

      You can chain multiple operations in two ways:

      **Using `BasicCalculator`**:
        ```java
        Object[][] operations = {
            {Operation.ADD, 10},
            {exponentiation, 2},
            {Operation.MULTIPLY, 2},
            {Operation.SUBTRACT, 100}
        };
  
        Number chainResult = calculator.chainCalculate(10, operations);
        System.out.println(chainResult); // Outputs: 700.0
      ```
      **Using `ChainCalculatorBuilder`**:
      ```java
          Number chainResult = new ChainCalculatorBuilder()
               .setInitValue(10)
               .addOperation(Operation.ADD, 10)
               .addOperation(exponentiation, 2)
               .addOperation(Operation.MULTIPLY, 2)
               .addOperation(Operation.SUBTRACT, 100)
               .calculate();
    
        System.out.println(chainResult); // Outputs: 700.0
  

### Running Tests

To run the unit tests:

1. From your IDE, run the `BasicCalculatorTest` class.
2. Or, from the command line:
    ```bash
    mvn test
    ```

### Extending the Calculator

To add new operations:

1. Implement the `OperationStrategy` interface.
2. Add the new operation to the `OperationStrategyFactory`.
3. Use the new operation as needed in calculations.
