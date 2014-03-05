package parser;

import evaluator.Expression;
import java.util.Stack;

public interface ExpressionFactory {
    
    public Expression build(Token token);

    public Stack<Expression> getExpressionStack();
}
