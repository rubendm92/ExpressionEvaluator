package evaluator.operators;

import java.util.HashMap;

public class BinaryOperatorFactory {
    
    private static final BinaryOperatorFactory INSTANCE = new BinaryOperatorFactory();
    private final HashMap<String, Builder> builders;
    
    private BinaryOperatorFactory() {
        builders = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        builders.put("IntegerIntegerAdd", new Builder() {

            @Override
            public BinaryOperator build(Object left, Object right) {
                return new IntegerIntegerAddOperator(left, right);
            }
        });
        builders.put("IntegerDoubleAdd", new Builder() {

            @Override
            public BinaryOperator build(Object left, Object right) {
                return new IntegerDoubleAddOperator(left, right);
            }
        });
        builders.put("DoubleIntegerAdd", new Builder() {

            @Override
            public BinaryOperator build(Object left, Object right) {
                return new DoubleIntegerAddOperator(left, right);
            }
        });
        builders.put("DoubleDoubleAdd", new Builder() {

            @Override
            public BinaryOperator build(Object left, Object right) {
                return new DoubleDoubleAddOperator(left, right);
            }
        });
    }
    
    public static BinaryOperatorFactory getInstance() {
        return INSTANCE;
    }
    
    public BinaryOperator getOperator(Object left, Object right) {
        String signature = left.getClass().getSimpleName() + right.getClass().getSimpleName() + "Add";
        return builders.get(signature).build(left, right);
    }
    
    private interface Builder {
        public BinaryOperator build(Object left, Object right);
    }
}
