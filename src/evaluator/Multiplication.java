package evaluator;

public class Multiplication extends BinaryOperation<Object>{

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected String signature() {
        return getSimpleName(left.evaluate()) + getSimpleName(right.evaluate()) + getClass().getSimpleName();
    }
}
