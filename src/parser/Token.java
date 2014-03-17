package parser;

public abstract class Token {

    public static <Type>Constant constant(Type value) {
        return new Constant(value);
    }
    
    public static Symbol symbol(String token, int precedence) {
        return new Symbol(token, precedence);
    }

    public static class Constant<Type> extends Token {
        private final Type value;

        private Constant(Type symbol) {
            this.value = symbol;
        }

        public Object value() {
            return value;
        }
    }

    public static class Symbol extends Token implements Comparable<Symbol>{
        
        private final String symbol;
        private final int precedence;

        private Symbol(String symbol, int precedence) {
            this.symbol = symbol;
            this.precedence = precedence;
        }
        
        public String symbol() {
            return symbol;
        }

        @Override
        public int compareTo(Symbol symbol) {
            return (precedence - symbol.precedence);
        }
    }
}
