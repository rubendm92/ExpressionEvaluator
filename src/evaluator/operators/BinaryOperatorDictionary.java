package evaluator.operators;

import java.util.HashMap;

public class BinaryOperatorDictionary {
    
    private static final BinaryOperatorDictionary INSTANCE = new BinaryOperatorDictionary();
    private final HashMap<String, BinaryOperator> operators;
    
    private BinaryOperatorDictionary() {
        operators = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        operators.put("IntegerIntegerAddition", new IntegerIntegerAddOperator());
        operators.put("IntegerDoubleAddition", new IntegerDoubleAddOperator());
        operators.put("DoubleIntegerAddition", new DoubleIntegerAddOperator());
        operators.put("DoubleDoubleAddition", new DoubleDoubleAddOperator());
    }
    
    public static BinaryOperatorDictionary getInstance() {
        return INSTANCE;
    }
    
    public BinaryOperator getOperator(String signature) {
        return operators.get(signature);
    }
}
