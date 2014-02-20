package evaluator.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorDictionary {
    
    private static final BinaryOperatorDictionary INSTANCE = new BinaryOperatorDictionary();
    private final HashMap<String, BinaryOperator> operators;
    
    private BinaryOperatorDictionary() {
        operators = new HashMap<>();
        addOperators();
    }
    
    private void addOperators() {
        ArrayList<Class> classes = new BinaryOperatorLoader().loadClasses();
        for (Class i : classes) {
            try {
                operators.put(getOperatorSignature(i), (BinaryOperator) i.newInstance());
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(BinaryOperatorDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String getOperatorSignature(Class name) {
        return name.getSimpleName().replace("Operator", "");
    }
    
    public static BinaryOperatorDictionary getInstance() {
        return INSTANCE;
    }
    
    public BinaryOperator getOperator(String signature) {
        return operators.get(signature);
    }
}
