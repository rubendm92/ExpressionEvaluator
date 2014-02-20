package evaluator.operators;

public class DoubleIntegerMultiplyOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left * (Integer) right;
    }
}
