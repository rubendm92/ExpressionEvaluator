package parser;

import evaluator.Expression;
import evaluator.operations.binary.Addition;
import evaluator.operations.binary.Division;
import evaluator.operations.binary.Multiplication;
import evaluator.operations.binary.Subtraction;
import java.util.HashMap;

public class OperationFactory {
    private final HashMap<String, Builder> builders;
    
    public OperationFactory() {
        this.builders = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        builders.put("+", new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Addition(left, right);
            }
        });
        builders.put("-", new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Subtraction(left, right);
            }
        });
        builders.put("*", new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Multiplication(left, right);
            }
        });
        builders.put("/", new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Division(left, right);
            }
        });
    }
    
    public Expression buildOperation(String operator, Expression left, Expression right) {
        return builders.get(operator).build(left, right);
    }

    private interface Builder {
        public Expression build(Expression left, Expression right);
    }
}
