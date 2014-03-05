package parser;

public abstract class Token {

    public static <Type>Constant constant(Type value) {
        return new Constant(value);
    }
    
    public static <Type>Symbol symbol(Type token) {
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

    public static class Symbol<Type> extends Token {
        private final Type token;

        private Symbol(Type token) {
            this.token = token;
        }
    }
}
