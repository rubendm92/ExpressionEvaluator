package evaluator.operators;

import evaluator.operators.addition.IntegerIntegerAddOperator;
import evaluator.operators.addition.IntegerDoubleAddOperator;
import evaluator.operators.addition.DoubleDoubleAddOperator;
import evaluator.operators.addition.DoubleIntegerAddOperator;
import evaluator.operators.multiplication.IntegerDoubleMultiplyOperator;
import evaluator.operators.multiplication.IntegerIntegerMultiplyOperator;
import evaluator.operators.multiplication.DoubleDoubleMultiplyOperator;
import evaluator.operators.multiplication.DoubleIntegerMultiplyOperator;
import java.util.HashMap;

public class BinaryOperatorDictionary {
    
    private static final BinaryOperatorDictionary INSTANCE = new BinaryOperatorDictionary();
    private final HashMap<String, BinaryOperator> operators;
    
    private BinaryOperatorDictionary() {
        operators = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        additionOperators();
        multiplyOperators();
    }

    private void additionOperators() {
        operators.put("IntegerIntegerAddition", new IntegerIntegerAddOperator());
        operators.put("IntegerDoubleAddition", new IntegerDoubleAddOperator());
        operators.put("DoubleIntegerAddition", new DoubleIntegerAddOperator());
        operators.put("DoubleDoubleAddition", new DoubleDoubleAddOperator());
    }
    
    private void multiplyOperators() {
        operators.put("IntegerIntegerMultiplication", new IntegerIntegerMultiplyOperator());
        operators.put("IntegerDoubleMultiplication", new IntegerDoubleMultiplyOperator());
        operators.put("DoubleIntegerMultiplication", new DoubleIntegerMultiplyOperator());
        operators.put("DoubleDoubleMultiplication", new DoubleDoubleMultiplyOperator());
    }
    
    public static BinaryOperatorDictionary getInstance() {
        return INSTANCE;
    }
    
    public BinaryOperator getOperator(String signature) {
        return operators.get(signature);
    }
}
