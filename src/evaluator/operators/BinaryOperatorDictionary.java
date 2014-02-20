package evaluator.operators;

import java.util.HashMap;

public class BinaryOperatorDictionary {
    
    private static final BinaryOperatorDictionary INSTANCE = new BinaryOperatorDictionary();
    private final HashMap<String, BinaryOperator> builders;
    
    private BinaryOperatorDictionary() {
        builders = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        builders.put("IntegerIntegerAddition", new IntegerIntegerAddOperator());
        builders.put("IntegerDoubleAddition", new IntegerDoubleAddOperator());
        builders.put("DoubleIntegerAddition", new DoubleIntegerAddOperator());
        builders.put("DoubleDoubleAddition", new DoubleDoubleAddOperator());
    }
    
    public static BinaryOperatorDictionary getInstance() {
        return INSTANCE;
    }
    
    public BinaryOperator getOperator(String signature) {
        return builders.get(signature);
    }
}
