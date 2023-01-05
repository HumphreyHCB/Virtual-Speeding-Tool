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


public class Reader {
    
  public static void main(String[] args) {
    
    HashMap<String, Long> map = Reader.readjson(args[0]);

    printRawtoConsole(map);

    generateReport(map);

  }
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

    public static void generateReport (HashMap<String, Long> map) {
      Long noMethod = map.remove("#No-Method#");
      HashMap<String, Long> sortedmap = sortByValue(map, true);
    
      ArrayList<List<String>> data = new ArrayList<List<String>>();

      for (String key : sortedmap.keySet()) {
        data.add(Arrays.asList(key, Double.toString(Math.round(100 * ((noMethod - sortedmap.get(key)) / (double)noMethod))) + "%"));
        
      }

      String[][] tabledata = new String[data.size() + 1][2];
      tabledata[0][0] = "Method Name";
      tabledata[0][1] = "Percentage Change";
      for (int i = 1; i < tabledata.length; i++) {
        tabledata[i][0] = data.get(i - 1).get(0);
        tabledata[i][1] = data.get(i - 1).get(1);
      }

      simpleTable(tabledata);




    }

    private static HashMap<String, Long> sortByValue(HashMap<String, Long> unsortMap, final boolean order)
    {
        List<Entry<String, Long>> list = new LinkedList<>(unsortMap.entrySet());
      
        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }
    private static void simpleTable(String[][] table) {
      // not mine
      /*
       * leftJustifiedRows - If true, it will add "-" as a flag to format string to
       * make it left justified. Otherwise right justified.
       */
      boolean leftJustifiedRows = true;
    
      /*
       * Table to print in console in 2-dimensional array. Each sub-array is a row.
       */
      // String[][] table = new String[][] { { "id", "First Name", "Last Name", "Age" },
      //     { "1", "John", "Johnson", "45" }, { "2", "Tom", "", "35" }, { "3", "Rose", "Johnson", "22" },
      //     { "4", "Jimmy", "Kimmel", "" } };
      
      /*
       * Calculate appropriate Length of each column by looking at width of data in
       * each column.
       * 
       * Map columnLengths is <column_number, column_length>
       */
      Map<Integer, Integer> columnLengths = new HashMap<>();
      Arrays.stream(table).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
        if (columnLengths.get(i) == null) {
          columnLengths.put(i, 0);
        }
        if (columnLengths.get(i) < a[i].length()) {
          columnLengths.put(i, a[i].length());
        }
      }));
      System.out.println("columnLengths = " + columnLengths);
    
      /*
       * Prepare format String
       */
      final StringBuilder formatString = new StringBuilder("");
      String flag = leftJustifiedRows ? "-" : "";
      columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
      formatString.append("|\n");
      System.out.println("formatString = " + formatString.toString());
    
      /*
       * Print table
       */
      Stream.iterate(0, (i -> i < table.length), (i -> ++i))
          .forEach(a -> System.out.printf(formatString.toString(), table[a]));
    
    }
  
  }

  