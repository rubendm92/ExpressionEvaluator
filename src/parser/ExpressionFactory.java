package parser;

import evaluator.Expression;

public interface ExpressionFactory {
    
    public Expression build(Token token);
}
