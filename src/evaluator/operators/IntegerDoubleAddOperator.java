package evaluator.operators;

public class IntegerDoubleAddOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left + (Double) right;
    }
}
