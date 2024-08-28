import org.example.calculator.BasicCalculator;
import org.example.calculator.Calculator;
import org.example.calculator.Operation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicCalculatorTest {

    @Test
    public void testAddOperation() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.ADD, 10, 5);
        assertEquals(15.0, result);
    }

    @Test
    public void testSubtractOperation() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.SUBTRACT, 10, 5);
        assertEquals(5.0, result);
    }

    @Test
    public void testMultiplyOperation() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.MULTIPLY, 10, 5);
        assertEquals(50.0, result);
    }

    @Test
    public void testDivideOperation() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.DIVIDE, 10, 5);
        assertEquals(2.0, result);
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new BasicCalculator();
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 10, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        Calculator calculator = new BasicCalculator();
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 10, 5);
        });
    }

    @Test
    public void testChainOperations() {
        Calculator calculator = new BasicCalculator();
        Object[][] operations = {
                {Operation.ADD, 10},
                {Operation.MULTIPLY, 2},
                {Operation.SUBTRACT, 5}
        };

        Number result = calculator.chainCalculate(10, operations);
        assertEquals(35.0, result);
    }
}
