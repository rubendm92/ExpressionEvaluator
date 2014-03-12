package evaluator.operations.binary;

import evaluator.Expression;
import evaluator.operators.binary.BinaryOperatorFactory;

public abstract class BinaryOperation<Type> implements Expression<Type> {

    protected Expression left;
    protected Expression right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Type evaluate() {
        return (Type) BinaryOperatorFactory.getInstance().createOperator(getClass().getSimpleName(), signature()).evaluate(left.evaluate(), right.evaluate());
    }

    protected String signature() {
        return getSimpleName(left.evaluate()) + getSimpleName(right.evaluate()) + getClass().getSimpleName() + "Operator";
    }

    protected String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }
}
