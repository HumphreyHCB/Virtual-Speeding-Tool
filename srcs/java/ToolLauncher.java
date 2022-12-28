package launchers;

import tool.Anatomizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ToolLauncher {
    
    public static void main(String[] args) {
        String filename = args[0];
        
        Anatomizer anatomizer = new Anatomizer(filename);
        ArrayList<String> methods = anatomizer.reflectMethods();
        methods.add(0, "#No-Method#");       
        
        

        EspressoLauncher EL = new EspressoLauncher();
         for (String method : methods) {
             EL.LaunchFileWithTool(filename, "10" , method);
        }

        System.out.println(methods);


    }


}
