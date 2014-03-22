package evaluator.operators.binary.multiplication;

import datatype.ComplexNumber;
import evaluator.Constant;
import evaluator.operations.binary.Multiplication;
import evaluator.operators.binary.BinaryOperator;

public class ComplexNumberIntegerMultiplicationOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return new ComplexNumber(new Multiplication(getReal(left), new Constant(right)).evaluate(), new Multiplication(getImaginary(left), new Constant(right)).evaluate());
    }
    
    private Constant getReal(Object object) {
        return new Constant(((ComplexNumber) object).getReal());
    }
    
    private Constant getImaginary(Object object) {
        return new Constant(((ComplexNumber) object).getImaginary());
    }
}
