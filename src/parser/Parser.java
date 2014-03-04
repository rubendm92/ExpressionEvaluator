package parser;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.operations.Addition;
import evaluator.operations.Multiplication;
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
        while (!symbols.isEmpty())
            process(symbols.pop());
        return expressions.pop();
    }

    private void parse(Token token) {
        if (token instanceof Token.Constant) {
            expressions.push(new Constant(getValue((Token.Constant) token)));
        } else if (token instanceof Token.Symbol) {
            if (newSymbolHasLessPrecedenceThanTop((Token.Symbol)token))
                process(symbols.pop());
            symbols.push((Token.Symbol)token);
        }
    }
    
    private void process(Token.Symbol symbol) {
        Expression right = expressions.pop();
        Expression left = expressions.pop();
        if (symbol.equals("+")) {
            expressions.push(new Addition(left, right));
        } else if (symbol.equals("*")) {
            expressions.push(new Multiplication(left, right));
        }
    }

    private Object getValue(Token.Constant constant) {
        return constant.value();
    }

    private boolean newSymbolHasLessPrecedenceThanTop(Token.Symbol symbol) {
        if (symbols.isEmpty()) return false;
        return (symbols.get(symbols.size() - 1).equals("*") && symbol.equals("+"));
    }
}
