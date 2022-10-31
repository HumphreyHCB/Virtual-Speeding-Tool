package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventListener;

public class MethodListener implements ExecutionEventListener{

    long slowdown;
    long speedUp;
    String providedMethod;
    
    public MethodListener(long slowdown, long speedUp, String providedMethod){
        this.slowdown = slowdown;
        this.speedUp = speedUp;
        this.providedMethod = providedMethod;
    }

    @Override
    public void onReturnValue(EventContext context, VirtualFrame frame, Object result) {
    }
  

    @Override
    public void onEnter(EventContext context, VirtualFrame frame) {

        if ( slowdown  <= 0) {return;}
        
        String callSrc = (String) context.getInstrumentedSourceSection().getCharacters();
        String[] callSrcSplit = callSrc.split("[(]");
        String[] optionsSplit = providedMethod.split("[(]");

        
    
        // i dont think this can fail
        if (callSrcSplit[0].equals(optionsSplit[0])) {
            //method_speedUp_count++;
            busyWaitMircros(speedUp);
        }
        else{
            //method_slowed_count++;
            busyWaitMircros(slowdown);
            
        }
        
    }

    @Override
    public void onReturnExceptional(EventContext context, VirtualFrame frame, Throwable exception) {
        // TODO Auto-generated method stub
        
    }

    public static void busyWaitMircros (long micros) {
        long waitUntil = System.nanoTime() + (micros * 1000);
        while (waitUntil > System.nanoTime()) {
            ;
        }
        
    }
}
