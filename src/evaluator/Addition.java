package evaluator;

import evaluator.operators.DoubleDoubleAddOperator;
import evaluator.operators.DoubleIntegerAddOperator;
import evaluator.operators.IntegerDoubleAddOperator;
import evaluator.operators.IntegerIntegerAddOperator;

public class Addition extends BinaryOperation<Object>{

    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        if (left.evaluate() instanceof Integer) {
            if (right.evaluate() instanceof Integer) {
                return new IntegerIntegerAddOperator(left.evaluate(), right.evaluate()).evaluate();
            } else if (right.evaluate() instanceof Double) {
                return new IntegerDoubleAddOperator(left.evaluate(), right.evaluate()).evaluate();
            }
        } else if (left.evaluate() instanceof Double) {
            if (right.evaluate() instanceof Integer) {
                return new DoubleIntegerAddOperator(left.evaluate(), right.evaluate()).evaluate();
            } else if (right.evaluate() instanceof Double) {
                return new DoubleDoubleAddOperator(left.evaluate(), right.evaluate()).evaluate();
            }
        }
        return null;
    }
}
