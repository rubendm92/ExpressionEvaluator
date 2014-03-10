package parser;

import evaluator.Expression;

public interface ParserTreeBuildingStrategy {
    
    public void build(Token token);
    
    public Expression getExpression();
}
