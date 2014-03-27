package evaluator.operations;

import evaluator.Expression;
import evaluator.operators.unary.UnaryOperatorFactory;

public abstract class UnaryOperation<Type> implements Expression<Type> {
    
    protected Expression expression;

    public UnaryOperation(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public Type evaluate() {
        return (Type) UnaryOperatorFactory.getInstance().createOperator(getClass().getSimpleName(), signature()).evaluate(expression.evaluate());
    }
    
    private String signature() {
        return getSimpleName(expression.evaluate()) + getClass().getSimpleName() + "Operator";
    }

    private String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }
}
