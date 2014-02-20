package evaluator.operators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorLoader {

    public ArrayList<Class> loadClasses() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = "evaluator.operators.".replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<>();
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                dirs.add(new File(resource.getFile()));
            }
            ArrayList<Class> classes = new ArrayList<>();
            for (File directory : dirs) {
                classes.addAll(findClasses(directory, "evaluator.operators"));
            }
            return getSubclassesImplementingInterface(classes, BinaryOperator.class);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BinaryOperatorLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    private ArrayList<Class> getSubclassesImplementingInterface(ArrayList<Class> classes, Class requestedInterface) {
        ArrayList<Class> operators = new ArrayList<>();
        for (Class i : classes)
            if (classImplementsInterface(i, requestedInterface))
                operators.add(i);
        return operators;
    }
    
    private boolean classImplementsInterface(Class classObject, Class requestedInterface) {
        List<Class> interfaces = Arrays.asList(classObject.getInterfaces());
        return interfaces.contains(requestedInterface);
    }

    private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        if (!directory.exists()) return new ArrayList<>();
        File[] files = directory.listFiles();
        return getClasses(files, packageName);
    }

    private List<Class> getClasses(File[] files, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory())
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            else if (file.getName().endsWith(".class"))
                classes.add(Class.forName(packageName + '.' + file.getName().replace(".class", "")));
        }
        return classes;
    }
}
