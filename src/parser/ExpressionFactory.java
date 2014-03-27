package parser;

import evaluator.Constant;
import evaluator.Expression;
import parser.token.Symbol;

public interface ExpressionFactory {

    public Constant buildConstant(parser.token.Constant token);

    public Expression buildOperation(Symbol symbol, Expression left, Expression right);
}
