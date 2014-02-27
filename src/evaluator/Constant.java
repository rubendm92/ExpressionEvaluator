package evaluator;

public class Constant<Type> implements Expression<Type> {

    private final Type value;

    public Constant(Type value) {
        this.value = value;
    }

    @Override
    public Type evaluate() {
        return value;
    }
}
