package evaluator.operators;

public abstract class BinaryOperator {
    
    protected Object left;
    protected Object right;

    public BinaryOperator(Object left, Object right) {
        this.left = left;
        this.right = right;
    }
    
    public abstract Object evaluate();
}
