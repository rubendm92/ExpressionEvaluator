package evaluator.operators;

public class DoubleDoubleMultiplyOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left * (Double) right;
    }
}
