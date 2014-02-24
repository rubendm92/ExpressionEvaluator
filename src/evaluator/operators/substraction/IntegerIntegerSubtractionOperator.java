package evaluator.operators.substraction;

import evaluator.operators.BinaryOperator;

public class IntegerIntegerSubtractionOperator implements BinaryOperator{
    
    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left - (Integer) right;
    }
}
