package parser;

import evaluator.Expression;
import parser.Token;

public interface ExpressionFactory {
    
    public Expression build(Token token);
}
