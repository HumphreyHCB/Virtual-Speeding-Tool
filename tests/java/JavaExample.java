package code;

import java.util.Random;

public class JavaExample extends Benchmark {

    public static void myprint() {
        System.out.println("Hello");
        System.out.println("This is my Print");
        testMaths();
        testMaths();
    }

    public static void testMaths() {
        int x = 7;
        int y = 12;
        Random rand = new Random();
        int z = x + y;
        System.out.println(z - rand.nextInt(5));
    }
    @Override
    public Object benchmark() {
        testMaths();
        myprint();
      return true;
    }
  
    @Override
    public boolean verifyResult(final Object result) {
      return true;
    }
    
}
