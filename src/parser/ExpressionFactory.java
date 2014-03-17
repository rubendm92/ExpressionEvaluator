package parser;

import parser.token.Symbol;
import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.binary.Addition;
import evaluator.operations.binary.Division;
import evaluator.operations.binary.Multiplication;
import evaluator.operations.binary.Subtraction;
import java.util.HashMap;

public class ExpressionFactory {

    private final HashMap<Symbol, Builder> builders;
    
    public ExpressionFactory() {
        this.builders = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        builders.put(Symbol.ADD, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Addition(left, right);
            }
        });
        builders.put(Symbol.SUBTRACT, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Subtraction(left, right);
            }
        });
        builders.put(Symbol.MULTIPLY, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Multiplication(left, right);
            }
        });
        builders.put(Symbol.DIVIDE, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Division(left, right);
            }
        });
    }
    
    public Constant buildConstant(parser.token.Constant token) {
        return new Constant(token.value());
    }
    
    public Expression buildOperation(Symbol symbol, Expression left, Expression right) {
        return builders.get(symbol).build(left, right);
    }

    private interface Builder {
        public Expression build(Expression left, Expression right);
    }
}
