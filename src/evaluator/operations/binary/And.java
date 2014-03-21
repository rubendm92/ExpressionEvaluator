package evaluator.operations.binary;

import evaluator.Expression;

public class And extends BinaryOperation<Object> {

    public And(Expression left, Expression right) {
        super(left, right);
    }
}
