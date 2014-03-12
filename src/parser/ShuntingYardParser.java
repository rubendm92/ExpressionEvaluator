package parser;

import evaluator.Expression;
import java.util.Stack;

public class ShuntingYardParser implements Parser {
    
    private final ParserTreeBuildingStrategy strategy;
    private final Stack<Token.Symbol> symbols;

    public ShuntingYardParser(ParserTreeBuildingStrategy strategy) {
        this.strategy = strategy;
        this.symbols = new Stack<>();
    }

    @Override
    public Expression parse(Token[] tokens) {
        for (Token token : tokens)
            parse(token);
        return getExpression();
    }
    
    private void parse(Token token) {
        if (token instanceof Token.Constant)
            parseConstant((Token.Constant) token);
        else if (token instanceof Token.Symbol)
            parseSymbol((Token.Symbol) token);
    }
    
    private void parseConstant(Token.Constant constant) {
        strategy.build(constant);
    }

    private void parseSymbol(Token.Symbol symbol) {
        if (topSymbolHasMorePrecedenceThanNew(symbol))
            strategy.build(symbols.pop());
        symbols.push(symbol);
    }
    
    private Expression getExpression() {
        while(!symbols.isEmpty())
            strategy.build(symbols.pop());
        return strategy.getExpression();
    }

    private boolean topSymbolHasMorePrecedenceThanNew(Token.Symbol symbol) {
        if (symbols.isEmpty()) return false;
        if (symbol.symbol().equals("+") || symbol.symbol().equals("-")) {
            return (symbols.get(symbols.size() - 1).symbol().equals("*")) || (symbols.get(symbols.size() - 1).symbol().equals("/"));
        }
        return false;
    }
}