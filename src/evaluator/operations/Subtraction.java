package evaluator.operations;

import evaluator.Expression;

public class Subtraction extends BinaryOperation<Object> {

    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }
}
