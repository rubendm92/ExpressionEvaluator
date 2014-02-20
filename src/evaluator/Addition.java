package evaluator;

import evaluator.operators.BinaryOperatorDictionary;

public class Addition extends BinaryOperation<Object>{

    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        return BinaryOperatorDictionary.getInstance().getOperator(signature()).evaluate(left.evaluate(), right.evaluate());
    }

    private String signature() {
        return getSimpleName(left.evaluate()) + getSimpleName(right.evaluate()) + getClass().getSimpleName();
    }
    
    private String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }
}
