package evaluator.operators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorLoader {

    public ArrayList<Class> loadClasses() {
        ArrayList<Class> operators = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            assert classLoader != null;
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
            for (Class i : classes) {
                Class[] interfaces = i.getInterfaces();
                if (interfaces.length == 0) {
                    continue;
                }
                if (interfaces[0] == BinaryOperator.class) {
                    operators.add(i);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BinaryOperatorLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operators;
    }

    private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
