package evaluator;

import evaluator.operators.BinaryOperatorFactory;

public class Addition extends BinaryOperation<Object>{

    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        return new BinaryOperatorFactory().getOperator(left.evaluate(), right.evaluate()).evaluate();
    }
}
