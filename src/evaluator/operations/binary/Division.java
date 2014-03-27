package evaluator.operations.binary;

import evaluator.operations.BinaryOperation;
import evaluator.Expression;

public class Division extends BinaryOperation<Object> {

    public Division(Expression left, Expression right) {
        super(left, right);
    }
}
