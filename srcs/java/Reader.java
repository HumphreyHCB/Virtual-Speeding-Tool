package com.mycompany.app;

import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.HashMap;


public class Reader {
    
    public static void main(String[] args) {
        // args[0] = filename
        String filename = "toolLauncherdump2.txt";

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


    }

}
