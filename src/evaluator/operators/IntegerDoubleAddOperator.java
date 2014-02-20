package evaluator.operators;

public class IntegerDoubleAddOperator extends BinaryOperator{

    public IntegerDoubleAddOperator(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        return (Integer) left + (Double) right;
    }
}
