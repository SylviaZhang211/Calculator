import org.example.calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.calculator.exceptions.UnsupportedOperationException;

public class BasicCalculatorTest {

    private Calculator calculator;
    OperationStrategy exponentiation;
    @BeforeEach
    public void setUp() {
        calculator = new BasicCalculator();

        // Define a new custom operation: Exponentiation (Power)
          exponentiation = new OperationStrategy() {
            @Override
            public Number execute(Number base, Number exponent) {
                return Math.pow(base.doubleValue(), exponent.doubleValue());
            }
        };

        // Add the custom operation to the factory
        OperationStrategyFactory.getInstance().addOperation(exponentiation, exponentiation);
    }


    @Test
    public void testAddOperation() {

        Number result = calculator.calculate(Operation.ADD, 10, 5);
        assertEquals(15.0, result);
    }

    @Test
    public void testSubtractOperation() {

        Number result = calculator.calculate(Operation.SUBTRACT, 10, 5);
        assertEquals(5.0, result);
    }

    @Test
    public void testMultiplyOperation() {
        Number result = calculator.calculate(Operation.MULTIPLY, 10, 5);
        assertEquals(50.0, result);
    }

    @Test
    public void testDivideOperation() {

        Number result = calculator.calculate(Operation.DIVIDE, 10, 5);
        assertEquals(2.0, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 10, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {

        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 10, 5);
        });
    }

    @Test
    public void testChainOperations() {

        Object[][] operations = {
                {Operation.ADD, 10},
                {Operation.MULTIPLY, 2},
                {Operation.SUBTRACT, 5}
        };

        Number result = calculator.chainCalculate(10, operations);
        assertEquals(35.0, result);
    }

    @Test
    public void testCustomOperationExponentiation() {
       // OperationStrategy exponentiation = OperationStrategyFactory.getInstance().getStrategy();
        // Test the custom exponentiation operation individually
        Number result = calculator.calculate(exponentiation, 2, 3);
        assertEquals(8.0, result.doubleValue());  // 2^3 = 8
    }

    @Test
    public void testChainOperationsWithCustomExponentiation() {
        // Chain operations that include the custom exponentiation


        Object[][] operations = {
                {Operation.ADD, 10},
                {exponentiation, 2},  // (10 + 10) ^ 2 = 400
                {Operation.MULTIPLY, 2},  // 400 * 2 = 800
                {Operation.SUBTRACT, 100}  // 800 - 100 = 700
        };

        Number result = calculator.chainCalculate(10, operations);
        assertEquals(700.0, result.doubleValue());
    }

    @Test
    public void testCustomOperationWithNegativeExponent() {
        // Test custom exponentiation with a negative exponent
        // 2^-2 = 0.25
        Number result = calculator.calculate(exponentiation, 2, -2);
        assertEquals(0.25, result.doubleValue());
    }
}
