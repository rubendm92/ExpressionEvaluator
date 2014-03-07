package parser;

public abstract class Token {

    public static <Type>Constant constant(Type value) {
        return new Constant(value);
    }
    
    public static Symbol symbol(String token) {
        return new Symbol(token);
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

    public static class Symbol extends Token {
        private final String symbol;

        private Symbol(String symbol) {
            this.symbol = symbol;
        }
        
        public String symbol() {
            return symbol;
        }
    }
}
