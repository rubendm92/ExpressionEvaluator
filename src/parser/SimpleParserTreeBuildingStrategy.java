package parser;

import parser.token.Token;
import parser.token.Symbol;
import evaluator.Constant;
import evaluator.Expression;
import java.util.Stack;

public class SimpleParserTreeBuildingStrategy implements ParserTreeBuildingStrategy {

    private final Stack<Expression> expressions;
    private final ExpressionFactory factory;

    public SimpleParserTreeBuildingStrategy() {
        this.expressions = new Stack<>();
        this.factory = new ExpressionFactory();
    }

    @Override
    public void build(Token token) {
        if (token instanceof parser.token.Constant)
            expressions.add(buildConstant((parser.token.Constant) token));
        else
            expressions.add(buildOperation((Symbol) token));
    }
    
    private Constant buildConstant(parser.token.Constant token) {
        return factory.buildConstant(token);
    }
    
    private Expression buildOperation(Symbol symbol) {
        return factory.buildOperation(symbol, expressions.remove(0), expressions.remove(0));
    }

    @Override
    public Expression getExpression() {
        return expressions.pop();
    }
}