package evaluator.operations.binary;

import evaluator.operations.BinaryOperation;
import evaluator.Expression;

public class Xor extends BinaryOperation<Object>{

    public Xor(Expression left, Expression right) {
        super(left, right);
    }
}
