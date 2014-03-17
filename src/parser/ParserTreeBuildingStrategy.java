package parser;

import parser.token.Token;
import evaluator.Expression;

public interface ParserTreeBuildingStrategy {
    
    public void build(Token token);
    
    public Expression getExpression();
}
