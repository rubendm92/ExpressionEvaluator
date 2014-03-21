package evaluator.operators.binary.subtraction;

import evaluator.operators.binary.BinaryOperator;

public class StringStringSubtractionOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return ((String) left).replace((String) right, "");
    }
    
}
