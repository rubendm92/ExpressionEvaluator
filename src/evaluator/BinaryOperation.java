package evaluator;

import evaluator.operators.BinaryOperatorDictionary;

public abstract class BinaryOperation<Type> implements Expression<Type>{
    
    protected Expression left;
    protected Expression right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public Type evaluate() {
        return (Type) BinaryOperatorDictionary.getInstance().getOperator(signature()).evaluate(left.evaluate(), right.evaluate());
    }

    protected abstract String signature();
}
