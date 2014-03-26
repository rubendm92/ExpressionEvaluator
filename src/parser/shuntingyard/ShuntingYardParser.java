package parser.shuntingyard;

import evaluator.Expression;
import java.util.HashMap;
import java.util.Stack;
import parser.Parser;
import parser.ParserTreeBuildingStrategy;
import parser.token.Bracket;
import parser.token.Constant;
import parser.token.Operator;
import parser.token.Symbol;
import parser.token.Token;
import parser.token.Token.Handler;

public class ShuntingYardParser implements Parser {
    
    private final ParserTreeBuildingStrategy strategy;
    private final Stack<Symbol> symbols;
    private final HashMap<Class, Handler> handlers;
    
    public ShuntingYardParser(ParserTreeBuildingStrategy strategy) {
        this.strategy = strategy;
        this.symbols = new Stack<>();
        this.handlers = new HashMap<>();
        addHandlers();
    }
    
    private void addHandlers() {
        handlers.put(Constant.class, (Handler) (token) -> parseConstant(token));
        handlers.put(Operator.class, (Handler) (token) -> parseOperator((Operator) token));
        handlers.put(Bracket.Open.class, (Handler) (token) -> symbols.push((Bracket) token));
        handlers.put(Bracket.Close.class, (Handler) (token) -> buildContentInsideBracket());
    }
    
    @Override
    public Expression parse(Token[] tokens) {
        for (Token token : tokens)
            handlers.get(token.getClass()).handle(token);
        return getExpression();
    }
    
    private void parseConstant(Token token) {
        strategy.build(token);
    }
    
    private void buildContentInsideBracket() {
        while (symbols.peek() != Bracket.OPEN)
            strategy.build(symbols.pop());
        symbols.pop();
    }
    
    private void parseOperator(Operator operator) {
        while (!newSymbolHasMorePrecedenceThanTop(operator))
            strategy.build(symbols.pop());
        symbols.push(operator);
    }
    
    private boolean newSymbolHasMorePrecedenceThanTop(Symbol symbol) {
        if (symbols.empty() || symbols.peek() == Bracket.OPEN) return true;
        return ((Operator) symbol).compareTo((Operator) (symbols.peek())) > 0;
    }
    
    private Expression getExpression() {
        while (!symbols.empty())
            strategy.build(symbols.pop());
        return strategy.getExpression();
    }
}
