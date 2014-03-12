package evaluator.operators.unary;

import evaluator.operators.InvalidOperationException;

public class UnaryOperatorFactory {
    
    private static final UnaryOperatorFactory INSTANCE = new UnaryOperatorFactory();

    private UnaryOperatorFactory() {
    }
    
    public static UnaryOperatorFactory getInstance() {
        return INSTANCE;
    }
    
    public UnaryOperator createOperator(String operation, String operatorSignature) {
        String operator = "evaluator.operators.unary." + operation.toLowerCase() + "." + operatorSignature;
        try {
            return (UnaryOperator) Class.forName(operator).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new InvalidOperationException("No operator found for parameter");
        }
    }
}
