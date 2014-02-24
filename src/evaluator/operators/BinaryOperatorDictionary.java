package evaluator.operators;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;

public class BinaryOperatorDictionary {
    
    private static final BinaryOperatorDictionary INSTANCE = new BinaryOperatorDictionary();
    private final HashMap<String, BinaryOperator> operators;
    
    private BinaryOperatorDictionary() {
        operators = new HashMap<>();
        initOperators();
    }
    
    private void initOperators() {
        Reflections reflections = new Reflections("evaluator.operators");
        for (Class<? extends BinaryOperator> class1 : reflections.getSubTypesOf(BinaryOperator.class)) {
            try {
                operators.put(class1.getSimpleName(), class1.newInstance());
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(BinaryOperatorDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static BinaryOperatorDictionary getInstance() {
        return INSTANCE;
    }
    
    public BinaryOperator getOperator(String signature) {
        return operators.get(signature);
    }
}
