package evaluator.operations;

import evaluator.Expression;

public class Addition extends BinaryOperation<Object> {

    public Addition(Expression left, Expression right) {
        super(left, right);
    }
}
