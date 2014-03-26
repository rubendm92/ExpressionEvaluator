package evaluator.operators.binary.multiplication;

import datatype.ComplexNumber;
import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.binary.Addition;
import evaluator.operations.binary.Multiplication;
import evaluator.operations.binary.Subtraction;
import evaluator.operators.binary.BinaryOperator;

public class ComplexNumberComplexNumberMultiplicationOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return new ComplexNumber(subtractRealPart(left, right), addImaginaryPart(left, right));
    }

    private Object subtractRealPart(Object left, Object right) {
        return new Subtraction(constant(multiply(getReal(left), getReal(right))),
                constant(multiply(getImaginary(left), getImaginary(right)))).evaluate();
    }

    private Object addImaginaryPart(Object left, Object right) {
        return new Addition(constant(multiply(getReal(left), getImaginary(right))),
                constant(multiply(getImaginary(left), getReal(right)))).evaluate();
    }
    
    private Constant constant(Object object) {
        return new Constant(object);
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
