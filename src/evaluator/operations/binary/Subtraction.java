package evaluator.operations.binary;

import evaluator.operations.BinaryOperation;
import evaluator.Expression;

public class Subtraction extends BinaryOperation<Object> {

    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }
}
