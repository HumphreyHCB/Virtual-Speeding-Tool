package tool;

import java.io.File;  
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import org.json.JSONObject;


public class Reader {
    
    public HashMap<String, Integer> readtxt(String filename) {
                // args[0] = filename

                HashMap<String, Integer> Data = new HashMap<String, Integer>();
        
                try {
                    File myObj = new File(filename);
                    Scanner myReader = new Scanner(myObj);
                    
                      int numberofDataPoints = Integer.parseInt(myReader.nextLine());
                      String[] methods = new String[numberofDataPoints];
                      for (int i = 0; i < numberofDataPoints; i++) {
                        methods[i] = myReader.nextLine();
                      }
                      int[] values = new int[numberofDataPoints];
                      for (int i = 0; i < numberofDataPoints; i++) {
                        values[i] = Integer.parseInt(myReader.nextLine());               
                      }
        
                      for (int i = 0; i < numberofDataPoints; i++) {
                        Data.put(methods[i], values[i]);
                      }
        
                    
                    myReader.close();
                  } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }
                  return Data;
    }

    public static HashMap<String, Integer> readjson(String filename) {
    
        HashMap<String, Integer> Data = new HashMap<String, Integer>();

        try {
          String str = Files.readString(Path.of(filename));
            JSONObject jo = new JSONObject(str).getJSONObject("methods");
            Set<String> keySet = jo.keySet();
            for (String string : keySet) {
              Data.put(string, Integer.parseInt((String)jo.get(string)));
            }


        } catch (Exception e) {
          e.printStackTrace();
            // TODO: handle exception
        }

        return Data;
    }

}
