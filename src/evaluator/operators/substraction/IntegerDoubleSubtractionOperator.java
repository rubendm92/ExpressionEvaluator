package evaluator.operators.substraction;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleSubtractionOperator implements BinaryOperator{
    
    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left - (Double) right;
    }
}