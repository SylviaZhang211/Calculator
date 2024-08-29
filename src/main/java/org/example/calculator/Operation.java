package org.example.calculator;


public enum Operation implements OperationStrategy {
    ADD {
        @Override
        public Number execute(Number num1, Number num2) {
            return num1.doubleValue() + num2.doubleValue();
        }
    },
    SUBTRACT {
        @Override
        public Number execute(Number num1, Number num2) {
            return num1.doubleValue() - num2.doubleValue();
        }
    },
    MULTIPLY {
        @Override
        public Number execute(Number num1, Number num2) {
            return num1.doubleValue() * num2.doubleValue();
        }
    },
    DIVIDE {
        @Override
        public Number execute(Number num1, Number num2) {
            if (num2.doubleValue() == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return num1.doubleValue() / num2.doubleValue();
        }
    };
}

