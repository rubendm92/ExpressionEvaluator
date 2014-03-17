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
            while (true) {
                Symbol symbol = symbols.pop();
                if (symbol == Parenthesis.OPEN) break;
                strategy.build(symbol);
            }
        }
    }
    
    private void parseOperator(Operator operator) {
        if (topSymbolHasLessPrecedenceThanNew(operator))
            strategy.build(operator);
        else {
            if (equal(operator)) strategy.build(symbols.pop());
            symbols.push(operator);
        }
    }

    private Expression getExpression() {
        while (!symbols.empty()) {
            Symbol symbol = symbols.pop();
            if (symbol instanceof Parenthesis) {
                continue;
            }
            strategy.build(symbol);
        }
        return strategy.getExpression();
    }

    private boolean topSymbolHasLessPrecedenceThanNew(Symbol symbol) {
        if (symbols.isEmpty()) return false;
        if (symbols.get(symbols.size() - 1) == Parenthesis.OPEN) return false;
        Operator op = (Operator) symbol;
        Operator op1 = (Operator) symbols.get(symbols.size() - 1);
        return op.hasMorePrecedence(op1);
    }
    
    private boolean equal(Symbol symbol) {
        if (symbols.isEmpty()) return false;
        if (symbols.get(symbols.size() - 1) == Parenthesis.OPEN) return false;
        Operator op = (Operator) symbol;
        Operator op1 = (Operator) symbols.get(symbols.size() - 1);
        return op.hasEqualPrecedence(op1);
    }
}
