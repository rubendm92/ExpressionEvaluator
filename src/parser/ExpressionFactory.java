package parser;

import evaluator.Constant;
import evaluator.Expression;
import java.util.Stack;

public class ExpressionFactory {

    private final Stack<Expression> expressions;
    private final OperationFactory operationFactory;

    public ExpressionFactory() {
        this.expressions = new Stack<>();
        this.operationFactory = new OperationFactory();
    }
    
    public Expression build(Token token) {
        if (token instanceof Token.Constant)
            return buildConstant((Token.Constant) token);
        return buildOperation((Token.Symbol) token);
    }

    private Constant buildConstant(Token.Constant token) {
        return new Constant((token).value());
    }
    
    private Expression buildOperation(Token.Symbol symbol) {
        Expression right = expressions.pop();
        Expression left = expressions.pop();
        return operationFactory.buildOperation(symbol.symbol(), left, right);
    }

    public Stack<Expression> getExpressionStack() {
        return expressions;
    }
}
