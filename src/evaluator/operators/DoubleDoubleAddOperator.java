package evaluator.operators;

public class DoubleDoubleAddOperator extends BinaryOperator{

    public DoubleDoubleAddOperator(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        return (Double) left + (Double) right;
    }
}
