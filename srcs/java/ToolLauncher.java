package launchers;

import code.Anatomizer;
import java.util.Arrays;

public class ToolLauncher {
    
    public static void main(String[] args) {
        String filename = args[0];

        Anatomizer anatomizer = new Anatomizer(filename);
        String[] methods = anatomizer.reflectMethods();
        System.out.println(Arrays.toString(methods));

        EspressoLauncher EL = new EspressoLauncher();
        for (String method : methods) {
            EL.LaunchFileWithTool(filename, "10" , method);
        }


    }


}
