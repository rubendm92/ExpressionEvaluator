package parser;

import evaluator.Expression;
import java.util.Stack;

public class Parser {

    private final Stack<Token.Symbol> symbols;
    private final Stack<Expression> expressions;
    private final ExpressionFactory factory;

    public Parser(ExpressionFactory factory) {
        this.symbols = new Stack<>();
        this.expressions = factory.getExpressionStack();
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
        if (token instanceof Token.Constant)
            parseConstant((Token.Constant) token);
        else if (token instanceof Token.Symbol)
            parseSymbol((Token.Symbol) token);
    }

    private void parseConstant(Token.Constant constant) {
        expressions.push(factory.build(constant));
    }

    private void parseSymbol(Token.Symbol symbol) {
        if (newSymbolHasLessPrecedenceThanTop(symbol.symbol()))
            expressions.push(factory.build(symbols.pop()));
        symbols.push(symbol);
    }
    
    private void process(Token token) {
        expressions.push(factory.build(token));
    }

    private boolean newSymbolHasLessPrecedenceThanTop(String symbol) {
        if (symbols.isEmpty()) return false;
        return (symbols.get(symbols.size() - 1).symbol().equals("*") && symbol.equals("+"));
    }
}
