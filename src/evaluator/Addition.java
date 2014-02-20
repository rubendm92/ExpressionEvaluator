package evaluator;

public class Addition extends BinaryOperation<Object>{

    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected String signature() {
        return getSimpleName(left.evaluate()) + getSimpleName(right.evaluate()) + "Add";
    }
}
