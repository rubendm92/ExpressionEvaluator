package parser;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.binary.Addition;
import evaluator.operations.binary.Division;
import evaluator.operations.binary.Multiplication;
import evaluator.operations.binary.Subtraction;
import java.util.HashMap;
import parser.token.Operator;
import parser.token.Symbol;

public class ExpressionFactoryImpl implements ExpressionFactory {

    private final HashMap<Symbol, Builder> builders;
    
    public ExpressionFactoryImpl() {
        this.builders = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        builders.put(Operator.ADD, (Builder) (Expression left, Expression right) -> new Addition(left, right));
        builders.put(Operator.SUBTRACT, (Builder) (Expression left, Expression right) -> new Subtraction(left, right));
        builders.put(Operator.MULTIPLY, (Builder) (Expression left, Expression right) -> new Multiplication(left, right));
        builders.put(Operator.DIVIDE, (Builder) (Expression left, Expression right) -> new Division(left, right));
    }
    
    @Override
    public Constant buildConstant(parser.token.Constant token) {
        return new Constant(token.value());
    }
    
    @Override
    public Expression buildOperation(Symbol symbol, Expression left, Expression right) {
        return builders.get(symbol).build(left, right);
    }

    private interface Builder {
        public Expression build(Expression left, Expression right);
    }
}
