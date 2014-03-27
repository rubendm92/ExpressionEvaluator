package evaluator.operations.unary;

import evaluator.operations.UnaryOperation;
import evaluator.Expression;

public class Minus extends UnaryOperation<Object>{

    public Minus(Expression expression) {
        super(expression);
    }
}
