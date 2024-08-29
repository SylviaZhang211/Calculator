package org.example.calculator;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Singleton class for managing calculator operation strategies.
 */
public class OperationStrategyFactory {

    private static final OperationStrategyFactory INSTANCE = new OperationStrategyFactory();
    private final ConcurrentHashMap<OperationStrategy, OperationStrategy> strategies = new ConcurrentHashMap<>();

    private OperationStrategyFactory() {
        init();
    }

    public static OperationStrategyFactory getInstance() {
        return INSTANCE;
    }

    private void init() {
        strategies.put(Operation.ADD, Operation.ADD);
        strategies.put(Operation.SUBTRACT, Operation.SUBTRACT);
        strategies.put(Operation.MULTIPLY, Operation.MULTIPLY);
        strategies.put(Operation.DIVIDE, Operation.DIVIDE);
    }

    public OperationStrategy getStrategy(OperationStrategy operation) {
        return strategies.get(operation);
    }

    public void addOperation(OperationStrategy operation, OperationStrategy implementation) {
        strategies.put(operation, implementation);
    }

    public void removeOperation(OperationStrategy operation) {
        strategies.remove(operation);
    }
}
