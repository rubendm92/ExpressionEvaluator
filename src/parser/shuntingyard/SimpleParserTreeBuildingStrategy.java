package parser.shuntingyard;

import evaluator.Constant;
import evaluator.Expression;
import java.util.Stack;
import parser.ExpressionFactory;
import parser.ParserTreeBuildingStrategy;
import parser.token.Symbol;
import parser.token.Token;

public class SimpleParserTreeBuildingStrategy implements ParserTreeBuildingStrategy {

    private final Stack<Expression> expressions;
    private final ExpressionFactory factory;

    public SimpleParserTreeBuildingStrategy(ExpressionFactory factory) {
        this.expressions = new Stack<>();
        this.factory = factory;
    }

    @Override
    public void build(Token token) {
        if (token instanceof Symbol) expressions.add(buildOperation((Symbol) token));
        else expressions.add(buildConstant((parser.token.Constant) token));
    }
    
    private Expression buildOperation(Symbol symbol) {
        Expression right = expressions.pop();
        return factory.buildOperation(symbol, expressions.pop(), right);
    }

    private Constant buildConstant(parser.token.Constant token) {
        return factory.buildConstant(token);
    }
    
    @Override
    public Expression getExpression() {
        return expressions.pop();
    }
}