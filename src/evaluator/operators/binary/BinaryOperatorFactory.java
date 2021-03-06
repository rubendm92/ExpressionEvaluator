package evaluator.operators.binary;

import evaluator.operators.InvalidOperationException;

public class BinaryOperatorFactory {

    private static final BinaryOperatorFactory INSTANCE = new BinaryOperatorFactory();

    private BinaryOperatorFactory() {
    }

    public static BinaryOperatorFactory getInstance() {
        return INSTANCE;
    }

    public BinaryOperator createOperator(String operation, String operatorSignature) {
        String operator = "evaluator.operators.binary." + operation.toLowerCase() + "." + operatorSignature;
        try {
            return (BinaryOperator) Class.forName(operator).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new InvalidOperationException("No operator found for parameters");
        }
    }
}
