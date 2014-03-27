package evaluator.operations.binary;

import evaluator.operations.BinaryOperation;
import evaluator.Expression;

public class Or extends BinaryOperation<Object>{

    public Or(Expression left, Expression right) {
        super(left, right);
    }
}
