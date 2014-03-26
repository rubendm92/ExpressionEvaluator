package evaluator.operators.binary.subtraction;

import evaluator.Constant;
import evaluator.operations.binary.Subtraction;
import evaluator.operators.binary.BinaryOperator;
import java.util.ArrayList;

public class ArrayListArrayListSubtractionOperator implements BinaryOperator{
    
    @Override
    public Object evaluate(Object left, Object right) {
        return subtractLists((ArrayList) left, (ArrayList) right);
    }

    private Object subtractLists(ArrayList left, ArrayList right) {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < left.size(); i++)
            result.add(new Subtraction(new Constant(left.get(i)), new Constant(right.get(i))).evaluate());
        return result;
    }
}
