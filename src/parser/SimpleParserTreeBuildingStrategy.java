package parser;

import evaluator.Expression;
import java.util.Stack;

public class SimpleParserTreeBuildingStrategy implements ParserTreeBuildingStrategy {

    private final ExpressionFactory factory;
    private final Stack<Expression> expressions;

    public SimpleParserTreeBuildingStrategy() {
        this.factory = new ExpressionFactory();
        this.expressions = factory.getExpressionStack();
    }

    @Override
    public void build(Token token) {
        expressions.add(factory.build(token));
    }

    @Override
    public Expression getExpression() {
        return expressions.pop();
    }
}