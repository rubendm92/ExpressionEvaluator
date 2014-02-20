package evaluator.operators;

public class DoubleIntegerAddOperator extends BinaryOperator{

    public DoubleIntegerAddOperator(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        return (Double) left + (Integer) right;
    }
}
