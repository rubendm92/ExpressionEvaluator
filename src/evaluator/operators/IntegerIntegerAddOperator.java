package evaluator.operators;

public class IntegerIntegerAddOperator extends BinaryOperator{

    public IntegerIntegerAddOperator(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        return (Integer) left + (Integer) right;
    }
}
