package parser.shuntingyard;

import evaluator.Expression;
import java.util.HashMap;
import java.util.Stack;
import parser.Parser;
import parser.ParserTreeBuildingStrategy;
import parser.token.Constant;
import parser.token.Operator;
import parser.token.Parenthesis;
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
        handlers.put(Constant.class, (Handler) (Token token) -> parseConstant(token));
        handlers.put(Operator.class, (Handler) (token) -> parseOperator((Operator) token));
        handlers.put(Parenthesis.Open.class, (Handler) (token) -> symbols.push((Parenthesis) token));
        handlers.put(Parenthesis.Close.class, (Handler) (token) -> buildContentInsideParenthesis());
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
    
    private void buildContentInsideParenthesis() {
        while (symbols.peek() != Parenthesis.OPEN)
            strategy.build(symbols.pop());
        symbols.pop();
    }
    
    private void parseOperator(Operator operator) {
        while (!newSymbolHasMorePrecedenceThanTop(operator))
            strategy.build(symbols.pop());
        symbols.push(operator);
    }
    
    private boolean newSymbolHasMorePrecedenceThanTop(Symbol symbol) {
        if (symbols.empty() || symbols.peek() == Parenthesis.OPEN) return true;
        return ((Operator) symbol).compareTo((Operator) (symbols.peek())) > 0;
    }
    
    private Expression getExpression() {
        while (!symbols.empty())
            strategy.build(symbols.pop());
        return strategy.getExpression();
    }
}
