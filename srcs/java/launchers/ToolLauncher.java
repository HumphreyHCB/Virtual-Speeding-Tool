package launchers;

import tool.Anatomizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ToolLauncher {
    
    public static void main(String[] args) {
        String filename = args[0];
        
        Anatomizer anatomizer = new Anatomizer(filename);
        ArrayList<String> methods = anatomizer.reflectMethods();
        methods.add(0, "#No-Method#");       
        
        

        EspressoLauncher EL = new EspressoLauncher();
        String slowdown = "10";
         for (String method : methods) {
             EL.LaunchFileWithTool(filename, slowdown , method);
        }
        try {
            formatJSONfile();
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("Somthing has gone wrong while foormatting the json file");
          }
        

        System.out.println(methods);


    }

    public static void formatJSONfile() throws IOException {
        // what need to be done to the file to make it a vaild json file
        // add a opening brace and a closing brace
        // check that the last comment is correct
  
        String writeFilePath = new JSONObject(Files.readString(Path.of("env.json"))).getString("write-Path");
  
        String str = Files.readString(Path.of(writeFilePath));
        char[] s = str.trim().toCharArray();
        if (str.toString().trim().equals("")) {
          return;
        }
  
        // remove the extra commer
        s[s.length -1] = ' ';
  
        String finalFile = "{" + new String(s).trim() + "}";
        System.out.println(finalFile);
        FileWriter fw = new FileWriter(new File(writeFilePath), false);
        fw.write(finalFile);
  
        fw.close();
    }


}
