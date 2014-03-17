package parser.shuntingyard;

import parser.token.Token;
import parser.token.Symbol;
import parser.token.Constant;
import evaluator.Expression;
import java.util.Stack;
import parser.Parser;
import parser.ParserTreeBuildingStrategy;
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
        for (Token token : tokens) {
            parse(token);
        }
        return getExpression();
    }

    private void parse(Token token) {
        if (token instanceof Constant) {
            parseConstant((Constant) token);
        } else if (token instanceof Symbol) {
            parseSymbol((Symbol) token);
        }
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
        else if (parenthesis == Parenthesis.CLOSE) {
            buildContentInsideParenthesis();
        }
    }

    private void buildContentInsideParenthesis() {
        while (true) {
            Symbol symbol = symbols.pop();
            if (symbol == Parenthesis.OPEN) return;
            strategy.build(symbol);
        }
    }
    
    private void parseOperator(Operator operator) {
        if (compareNewSymbolWithTop(operator) > 0)
            strategy.build(operator);
        else {
            if (compareNewSymbolWithTop(operator) == 0) strategy.build(symbols.pop());
            symbols.push(operator);
        }
    }

    private Expression getExpression() {
        while (!symbols.empty()) {
            Symbol symbol = symbols.pop();
            if (symbol instanceof Parenthesis) continue;
            strategy.build(symbol);
        }
        return strategy.getExpression();
    }

    private int compareNewSymbolWithTop(Symbol symbol) {
        if (symbols.isEmpty()) return -1;
        if (topSymbol() == Parenthesis.OPEN) return -1;
        return operator(symbol).compareTo(operator(topSymbol()));
    }
    
    private Symbol topSymbol() {
        return symbols.get(symbols.size() - 1);
    }
    
    private Operator operator(Symbol symbol) {
        return (Operator) symbol;
    }
}
