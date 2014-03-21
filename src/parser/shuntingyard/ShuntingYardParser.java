package parser.shuntingyard;

import evaluator.Expression;
import java.util.Stack;
import parser.Parser;
import parser.ParserTreeBuildingStrategy;
import parser.token.Constant;
import parser.token.Operator;
import parser.token.Parenthesis;
import parser.token.Symbol;
import parser.token.Token;

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
        if (symbol instanceof Parenthesis)
            parseParenthesis((Parenthesis) symbol);
        else
            parseOperator((Operator) symbol);
    }

    private void parseParenthesis(Parenthesis parenthesis) {
        if (parenthesis == Parenthesis.OPEN)
            symbols.push(parenthesis);
        else if (parenthesis == Parenthesis.CLOSE)
            buildContentInsideParenthesis();
    }

    private void buildContentInsideParenthesis() {
        while (true) {
            Symbol symbol = symbols.pop();
            if (symbol == Parenthesis.OPEN) return;
            strategy.build(symbol);
        }
    }
    
    private void parseOperator(Operator operator) {
        while (compareNewSymbolWithTop(operator) <= 0)
            strategy.build(symbols.pop());
        symbols.push(operator);
    }

    private int compareNewSymbolWithTop(Symbol symbol) {
        if (symbols.empty()) return 1;
        if (symbols.peek() == Parenthesis.OPEN) return 1;
        return ((Operator) symbol).compareTo((Operator)(symbols.peek()));
    }
    
    private Expression getExpression() {
        while (!symbols.empty()) {
            Symbol symbol = symbols.pop();
            if (symbol instanceof Parenthesis) continue;
            strategy.build(symbol);
        }
        return strategy.getExpression();
    }
}
