package tool;

import tool.Benchmark;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

/* This code is based on the SOM class library.
*
* Copyright (c) 2001-2016 see AUTHORS.md file
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the 'Software'), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/
public final class Run {
  private final String                     name;
  private final Class<? extends Benchmark> benchmarkSuite;
  private int                              numIterations;
  private int                              innerIterations;
  private long                             total;
  private String                           slowdownMethod;
  private String                           writePath;
  private ArrayList<Long>               runTimes;

  public Run(final String name, final String slowdownMethod, final String writePath) {
    this.name = name;
    this.benchmarkSuite = getSuiteFromName(name);
    numIterations = 1;
    innerIterations = 1;
    this.slowdownMethod = slowdownMethod;
    this.writePath = writePath;
    runTimes = new ArrayList<Long>();
  }

  @SuppressWarnings("unchecked")
  private static Class<? extends Benchmark> getSuiteFromName(final String name) {
    try {
      return (Class<? extends Benchmark>) Class.forName("code."+name);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public void runBenchmark() {
    // Checkstyle: stop
    System.out.println("Starting " + name + " benchmark ...");
    // Checkstyle: resume

    try {
      doRuns(benchmarkSuite.newInstance());
    } catch (ReflectiveOperationException | IllegalArgumentException
        | SecurityException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    reportBenchmark();

    // Checkstyle: stop
    System.out.println();
    // Checkstyle: resume
  }

  private void measure(final Benchmark bench) {
    long startTime = System.nanoTime();
    if (!bench.innerBenchmarkLoop(innerIterations)) {
      throw new RuntimeException("Benchmark failed with incorrect result");
    }
    long endTime = System.nanoTime();
    long runTime = (endTime - startTime) / 1000;

    printResult(runTime);

    runTimes.add(runTime);
    total += runTime;
  }

  private void doRuns(final Benchmark bench) {
    for (int i = 0; i < numIterations; i++) {
      measure(bench);
    }
  }

  private void reportBenchmark() {
    for (int i = 0; i < (Math.floor(numIterations/10)); i++) {
      runTimes.remove(i);
    }

    Long alteredtotal = total;
    try {
      alteredtotal = 0L;
      for (Long i : runTimes) {
        alteredtotal += i;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // TODO: handle exception
    }


    long average = (alteredtotal /  Double.valueOf((numIterations - Math.floor(numIterations/10))).longValue());
    try {

      FileWriter out = new FileWriter(writePath, true);
        // Writing on output stream
        out.write("\"" + slowdownMethod + "\""+ ":"+ "\""+ average + "\"" +",\n");
        // Closing the connection
        out.close();
    }catch (Exception e) {
      e.printStackTrace();
        //exception handling left as an exercise for the reader
    }
    // Checkstyle: stop
    System.out.println(name + ": iterations=" + numIterations +
        " average: " + (total / numIterations) + "us total: " + total + "us\n");
    System.out.println("with the first 10% of iterations have been discounted\n");
    System.out.println(name + ": iterations=" + (numIterations - Math.floor(numIterations/10)) +
    " average: " + average + "us total: " + alteredtotal + "us\n");
    // Checkstyle: resume
  }

  private void printResult(final long runTime) {
    // Checkstyle: stop
    System.out.println(name + ": iterations=1 runtime: " + runTime + "us");
    // Checkstyle: resume
  }

  public void printTotal() {
    // Checkstyle: stop
    System.out.println("Total Runtime: " + total + "us");
    // Checkstyle: resume
  }

  public void setNumIterations(final int numIterations) {
    this.numIterations = numIterations;
  }

  public void setInnerIterations(final int innerIterations) {
    this.innerIterations = innerIterations;
  }
}
