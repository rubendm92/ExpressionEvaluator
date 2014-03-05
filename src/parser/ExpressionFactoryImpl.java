package parser;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.Addition;
import java.util.Stack;

public class ExpressionFactoryImpl implements ExpressionFactory{

    private final Stack<Expression> expressions;

    public ExpressionFactoryImpl() {
        this.expressions = new Stack<>();
    }
    
    @Override
    public Expression build(Token token) {
        if (token instanceof Token.Constant)
            return buildConstant(token);
        return buildOperation();
    }

    private Constant buildConstant(Token token) {
        return new Constant(((Token.Constant) token).value());
    }
    
    private Expression buildOperation() {
        Expression right = expressions.pop();
        Expression left = expressions.pop();
        return new Addition(left, right);
    }

    @Override
    public Stack<Expression> getExpressionStack() {
        return expressions;
    }
}
