package evaluator.operators;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorFactory {

    private static final BinaryOperatorFactory INSTANCE = new BinaryOperatorFactory();

    private BinaryOperatorFactory() {
    }

    public static BinaryOperatorFactory getInstance() {
        return INSTANCE;
    }

    public BinaryOperator createOperator(String operation, String operatorSignature) {
        String operator = "evaluator.operators." + operation.toLowerCase() + "." + operatorSignature;
        try {
            return (BinaryOperator) Class.forName(operator).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BinaryOperatorFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}