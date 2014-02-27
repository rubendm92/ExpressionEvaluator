package evaluator.operations;

import evaluator.Expression;

public class Multiplication extends BinaryOperation<Object> {

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }
}
