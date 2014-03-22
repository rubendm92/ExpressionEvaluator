package evaluator.operators.binary.addition;

import datatype.ComplexNumber;
import evaluator.Constant;
import evaluator.operations.binary.Addition;
import evaluator.operators.binary.BinaryOperator;

public class ComplexNumberComplexNumberAdditionOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return new ComplexNumber(addRealPart(left, right), addImaginaryPart(left, right));
    }

    private Object addRealPart(Object left, Object right) {
        return new Addition(getReal(left), getReal(right)).evaluate();
    }
    
    private Object addImaginaryPart(Object left, Object right) {
        return new Addition(getImaginary(left), getImaginary(right)).evaluate();
    }
    
    private Constant getReal(Object object) {
        return new Constant(((ComplexNumber) object).getReal());
    }
    
    private Constant getImaginary(Object object) {
        return new Constant(((ComplexNumber) object).getImaginary());
    }
}
