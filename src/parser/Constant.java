package parser;

public class Constant<Type> implements Token<Type> {
    
    private final Type value;

    public Constant(Type symbol) {
        this.value = symbol;
    }

    @Override
    public Type value() {
        return value;
    }
}
