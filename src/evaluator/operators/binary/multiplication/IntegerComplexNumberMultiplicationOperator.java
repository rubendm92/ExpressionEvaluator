package evaluator.operators.binary.multiplication;

import datatype.ComplexNumber;
import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.binary.Multiplication;
import evaluator.operators.binary.BinaryOperator;

public class IntegerComplexNumberMultiplicationOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return new ComplexNumber(multiply(new Constant(left), getReal(right)), multiply(new Constant(left), getImaginary(right)));
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
