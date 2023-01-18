package com.oracle.truffle.st;

import java.io.FileWriter;

import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;


class LineEventFactory implements ExecutionEventNodeFactory {

    private final long slowdown;
    private final long speedUp;
    private final String providedMethod;
    private final int lineNumber;
    public int method_speedUp_count;
    public int method_slowed_count;

    LineEventFactory(final Env env, final long slowdown, final long speedUp, final String providedMethod, final int lineNumber) {
        this.slowdown = slowdown;
        this.speedUp = speedUp;
        this.providedMethod = providedMethod;
        this.lineNumber = lineNumber;
        method_slowed_count = 0;
        method_speedUp_count = 0;

    }


    public ExecutionEventNode create(final EventContext ec) {

        if ( slowdown  == 0) {    
            return null;           
        }

        try {
            FileWriter out = new FileWriter("debugdump.txt", true);
              // Writing on output stream
              out.write(" Method: " + ec.getInstrumentedNode().getRootNode().toString()+ "line number" +ec.getInstrumentedNode().getSourceSection().getStartLine() + ",\n" );
              // Closing the connection
              out.close();
          }catch (Exception e) {
            e.printStackTrace();
              //exception handling left as an exercise for the reader
          }

        if (ec.getInstrumentedNode().getRootNode().toString().contains(providedMethod) && ec.getInstrumentedNode().getSourceSection().getStartLine() == lineNumber)
        {        
            method_speedUp_count++;
            return new SlowEventNode(speedUp);
        }
        else{
            method_slowed_count++;
            return new SlowEventNode(slowdown);
        }
        
    }


}