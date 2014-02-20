package evaluator.operators;

public class IntegerIntegerMultiplyOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left * (Integer) right;
    }
}
