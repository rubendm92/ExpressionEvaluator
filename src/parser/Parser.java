package parser;

import evaluator.Expression;

public interface Parser {

    public Expression parse(Token[] tokens);
}
