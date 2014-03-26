package evaluator.operators.binary.addition;

import evaluator.Constant;
import evaluator.operations.binary.Addition;
import evaluator.operators.binary.BinaryOperator;
import java.util.ArrayList;

public class ArrayListArrayListAdditionOperator implements BinaryOperator{
    
    @Override
    public Object evaluate(Object left, Object right) {
        return sumLists((ArrayList) left, (ArrayList) right);
    }

    private Object sumLists(ArrayList left, ArrayList right) {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < left.size(); i++)
            result.add(new Addition(new Constant(right.get(i)), new Constant(left.get(i))).evaluate());
        return result;
    }
}
