package evaluator;

public abstract class BinaryOperation<Type> implements Expression<Type>{
    
    protected Expression left;
    protected Expression right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
