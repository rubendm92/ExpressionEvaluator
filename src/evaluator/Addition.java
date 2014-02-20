package evaluator;

public class Addition extends BinaryOperation<Object>{

    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object evaluate() {
        if (left.evaluate() instanceof Integer) {
            if (right.evaluate() instanceof Integer) {
                return (Integer) left.evaluate() + (Integer) right.evaluate();
            } else if (right.evaluate() instanceof Double) {
                return (Integer) left.evaluate() + (Double) right.evaluate();
            }
        } else if (left.evaluate() instanceof Double) {
            if (right.evaluate() instanceof Integer) {
                return (Double) left.evaluate() + (Integer) right.evaluate();
            } else if (right.evaluate() instanceof Double) {
                return (Double) left.evaluate() + (Double) right.evaluate();
            }
        }
        return null;
    }
}
