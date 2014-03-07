package parser;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.Addition;
import evaluator.operations.Multiplication;
import java.util.Stack;

public class ExpressionFactoryImpl implements ExpressionFactory{

    private final Stack<Expression> expressions;

    public ExpressionFactoryImpl() {
        this.expressions = new Stack<>();
    }
    
    @Override
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
        if (symbol.symbol().equals("+"))
            return new Addition(left, right);
        else
            return new Multiplication(left, right);
    }

    @Override
    public Stack<Expression> getExpressionStack() {
        return expressions;
    }
}
