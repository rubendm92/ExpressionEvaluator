package parser;

import parser.token.Symbol;
import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.binary.Addition;
import evaluator.operations.binary.Division;
import evaluator.operations.binary.Multiplication;
import evaluator.operations.binary.Subtraction;
import java.util.HashMap;
import parser.token.Operator;
import parser.token.Parenthesis;

public class ExpressionFactory {

    private final HashMap<Symbol, Builder> builders;
    
    public ExpressionFactory() {
        this.builders = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        builders.put(Operator.ADD, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Addition(left, right);
            }
        });
        builders.put(Operator.SUBTRACT, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Subtraction(left, right);
            }
        });
        builders.put(Operator.MULTIPLY, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Multiplication(left, right);
            }
        });
        builders.put(Operator.DIVIDE, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                return new Division(left, right);
            }
        });
        builders.put(Parenthesis.OPEN, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                throw new RuntimeException("Parentesis abierto");
            }
        });
        builders.put(Parenthesis.CLOSE, new Builder() {

            @Override
            public Expression build(Expression left, Expression right) {
                throw new RuntimeException("Parentesis cerrado");
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
