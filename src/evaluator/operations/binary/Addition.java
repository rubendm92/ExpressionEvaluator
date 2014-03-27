package evaluator.operations.binary;

import evaluator.operations.BinaryOperation;
import evaluator.Expression;

public class Addition extends BinaryOperation<Object> {

    public Addition(Expression left, Expression right) {
        super(left, right);
    }
}
