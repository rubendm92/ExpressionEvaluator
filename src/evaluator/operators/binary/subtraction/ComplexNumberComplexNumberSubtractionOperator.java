package evaluator.operators.binary.subtraction;

import datatype.ComplexNumber;
import evaluator.Constant;
import evaluator.operations.binary.Subtraction;
import evaluator.operators.binary.BinaryOperator;

public class ComplexNumberComplexNumberSubtractionOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return new ComplexNumber(subtractRealPart(left, right), subtractImaginaryPart(left, right));
    }

    private Object subtractRealPart(Object left, Object right) {
        return new Subtraction(getReal(left), getReal(right)).evaluate();
    }
    
    private Object subtractImaginaryPart(Object left, Object right) {
        return new Subtraction(getImaginary(left), getImaginary(right)).evaluate();
    }
    
    private Constant getReal(Object object) {
        return new Constant(((ComplexNumber) object).getReal());
    }
    
    private Constant getImaginary(Object object) {
        return new Constant(((ComplexNumber) object).getImaginary());
    }
}
