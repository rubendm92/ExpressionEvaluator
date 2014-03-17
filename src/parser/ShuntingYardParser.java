package parser;

import parser.token.Token;
import parser.token.Symbol;
import parser.token.Constant;
import evaluator.Expression;
import java.util.Stack;
import parser.token.Operator;
import parser.token.Parenthesis;

public class ShuntingYardParser implements Parser {
    
    private final ParserTreeBuildingStrategy strategy;
    private final Stack<Symbol> symbols;

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
        if (token instanceof Constant)
            parseConstant((Constant) token);
        else if (token instanceof Symbol)
            parseSymbol((Symbol) token);
    }
    
    private void parseConstant(Constant constant) {
        strategy.build(constant);
    }

    private void parseSymbol(Symbol symbol) {
        if (symbol == Parenthesis.OPEN) {
            symbols.push(symbol);
            return;
        }
        if (symbol == Parenthesis.CLOSE) {
            while (true) {
                Symbol s = symbols.pop();
                if (s == Parenthesis.OPEN) break;
                strategy.build(s);
            }
            return;
        }
        if (topSymbolHasLessPrecedenceThanNew(symbol)) {
            strategy.build(symbol);
        }
        else {
            symbols.push(symbol);
        }
    }
    
    private Expression getExpression() {
        for (Symbol symbol : symbols) {
            if (symbol instanceof Parenthesis) continue;
            strategy.build(symbol);
        }
        return strategy.getExpression();
    }

    private boolean topSymbolHasLessPrecedenceThanNew(Symbol symbol) {
        if (symbols.isEmpty()) return false;
        if (symbols.get(symbols.size() - 1) == Parenthesis.OPEN) return false;
        if (symbols.get(symbols.size() - 1) == Parenthesis.CLOSE) return false;
        if (symbol == Parenthesis.CLOSE) return false;
        Operator op = (Operator) symbol;
        Operator op1 = (Operator) symbols.get(symbols.size() - 1);
        return op.hasMorePrecedence(op1);
    }
}
