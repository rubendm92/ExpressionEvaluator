package evaluator.operators.binary.multiplication;

import datatype.ComplexNumber;
import evaluator.Constant;
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
        return new Subtraction(new Constant(new Multiplication(getReal(left), getReal(right)).evaluate()), new Constant(new Multiplication(getImaginary(left), getImaginary(right)).evaluate())).evaluate();
    }
    
    private Object addImaginaryPart(Object left, Object right) {
        return new Addition(new Constant(new Multiplication(getReal(left), getImaginary(right)).evaluate()), new Constant(new Multiplication(getImaginary(left), getReal(right)).evaluate())).evaluate();
    }
    
    private Constant getReal(Object object) {
        return new Constant(((ComplexNumber) object).getReal());
    }
    
    private Constant getImaginary(Object object) {
        return new Constant(((ComplexNumber) object).getImaginary());
    }
}
