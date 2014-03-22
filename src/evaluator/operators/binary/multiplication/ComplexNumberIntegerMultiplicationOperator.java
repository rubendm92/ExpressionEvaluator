package evaluator.operators.binary.multiplication;

import datatype.ComplexNumber;
import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.binary.Multiplication;
import evaluator.operators.binary.BinaryOperator;

public class ComplexNumberIntegerMultiplicationOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return new ComplexNumber(multiply(getReal(left), new Constant(right)), multiply(getImaginary(left), new Constant(right)));
    }
    
    private Object multiply(Expression left, Expression right) {
        return new Multiplication(left, right).evaluate();
    }
    
    private Constant getReal(Object object) {
        return new Constant(((ComplexNumber) object).getReal());
    }
    
    private Constant getImaginary(Object object) {
        return new Constant(((ComplexNumber) object).getImaginary());
    }
}
