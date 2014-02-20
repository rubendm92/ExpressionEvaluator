package evaluator.operators;

public class IntegerIntegerAddOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left + (Integer) right;
    }
}
