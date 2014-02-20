package evaluator.operators;

public class BinaryOperatorFactory {
    
    public BinaryOperator getOperator(Object left, Object right) {
        if (left instanceof Integer) {
            if (right instanceof Integer) {
                return new IntegerIntegerAddOperator(left, right);
            } else if (right instanceof Double) {
                return new IntegerDoubleAddOperator(left, right);
            }
        } else if (left instanceof Double) {
            if (right instanceof Integer) {
                return new DoubleIntegerAddOperator(left, right);
            } else if (right instanceof Double) {
                return new DoubleDoubleAddOperator(left, right);
            }
        }
        return null;
    }
}
