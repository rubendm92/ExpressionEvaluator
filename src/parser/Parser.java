package parser;

import parser.token.Token;
import evaluator.Expression;

public interface Parser {

    public Expression parse(Token[] tokens);
}
