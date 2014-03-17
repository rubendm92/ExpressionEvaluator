package parser;

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
        if (token instanceof Token.Constant)
            expressions.add(buildConstant((Token.Constant) token));
        else
            expressions.add(buildOperation((Token.Symbol) token));
    }
    
    private Constant buildConstant(Token.Constant token) {
        return factory.buildConstant(token);
    }
    
    private Expression buildOperation(Token.Symbol symbol) {
        return factory.buildOperation(symbol.symbol(), expressions.remove(0), expressions.remove(0));
    }

    @Override
    public Expression getExpression() {
        return expressions.pop();
    }
}