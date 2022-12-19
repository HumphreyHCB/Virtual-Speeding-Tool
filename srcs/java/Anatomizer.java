package code;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Anatomizer {

    public static String fileName;
    private static String CLASS_FOLDER;
    
    public Anatomizer(String fileName){

        this.fileName = fileName;
        CLASS_FOLDER = "/home/hburchell/Repos/Virtual-Speeding-Tool/classes/";
    
    }

    public void setClassFolder(String folderPath){
        CLASS_FOLDER = folderPath;
    }

    public static void printUsage() {
        System.out.println("  From the Anatomizer: ");
        System.out.println("  ");
        System.out.println("  You will need to compile the the file you are trying to profile  ");
        System.out.println("  you may need to set the Class folder aswell");
        System.out.println("  ");
      }

    public static String[] reflectMethods()
    {
        try {

            Class c = getClassFromFile("code."+ fileName);
            Method[] methods = c.getDeclaredMethods();
            ArrayList<String> MethodNames = new ArrayList<String>();
            for (Method method : methods) {
                MethodNames.add(method.getName());
            }
            return MethodNames.toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            printUsage();
            return new String[0];
        } 
        
    }



    private static Class getClassFromFile(String fullClassName) throws Exception {
    URLClassLoader loader = new URLClassLoader(new URL[] {
        new URL("file://" + CLASS_FOLDER)
    });
    return loader.loadClass(fullClassName);
    }
}