package parser;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.Addition;
import java.util.Stack;

public class Parser {

    private final Stack<Token.Symbol> symbols;
    private final Stack<Expression> expressions;
    private final ExpressionFactory factory;

    public Parser(ExpressionFactory factory) {
        this.symbols = new Stack<>();
        this.expressions = new Stack<>();
        this.factory = factory;
    }

    public Expression parse(Token[] tokens) {
        for (Token token : tokens)
            parse(token);
        for (Token.Symbol symbol : symbols)
            process(symbol);
        return expressions.pop();
    }

    private void parse(Token token) {
        if (token instanceof Token.Constant) {
            expressions.push(new Constant(getValue((Token.Constant) token)));
        } else if (token instanceof Token.Symbol) {
            symbols.push((Token.Symbol)token);
        }
    }
    
    private void process(Token.Symbol symbol) {
        Expression right = expressions.pop();
        Expression left = expressions.pop();
        if (symbol.equals("+")) {
            expressions.push(new Addition(left, right));
        }
    }

    private Object getValue(Token.Constant constant) {
        return constant.value();
    }
}
