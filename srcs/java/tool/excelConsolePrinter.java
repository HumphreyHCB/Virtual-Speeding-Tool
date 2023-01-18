package tool;

import java.io.File;  
import java.io.FileNotFoundException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;


public class excelConsolePrinter {
    
  public static void main(String[] args) {
    HashMap<String, Long> map;
    for (String string : args) {
      map = excelConsolePrinter.readjson(string);

      printRawtoConsole(map);

    }
    
    

  }


    public static HashMap<String, Long> readjson(String filename) {
    
        HashMap<String, Long> Data = new HashMap<String, Long>();

        try {
          String str = Files.readString(Path.of(filename));
            JSONObject jo = new JSONObject(str);
            Set<String> keySet = jo.keySet();
            for (String string : keySet) {
              Data.put(string, Long.parseLong((String)jo.get(string)));
            }


        } catch (Exception e) {
          e.printStackTrace();
            // TODO: handle exception
        }

        return Data;
    }

    public static void printRawtoConsole(HashMap<String, Long> map) {

    System.out.println("");  

    for (String key : map.keySet()) {
       System.out.println(key);
    }
    for (Long value : map.values()) {
      System.out.println(value);
   }
   System.out.println("");  

    }

    
  
  }

  