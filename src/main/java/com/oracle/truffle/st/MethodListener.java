package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventListener;

public class MethodListener implements ExecutionEventListener{

    final long slowdown;
    final long speedUp;
    final String providedMethod;
    int method_speedUp_count = 0;
    int method_slowed_count = 0;
    
    public MethodListener(final long slowdown, final long speedUp, final String providedMethod){
        this.slowdown = slowdown;
        this.speedUp = speedUp;
        this.providedMethod = providedMethod;
    }

    @Override
    public void onReturnValue(EventContext context, VirtualFrame frame, Object result) {
    }
  

    @Override
    public void onEnter(EventContext context, VirtualFrame frame) {

        if ( slowdown  <= 0) {    
            return;           
        }
        //CompilerDirectives.transferToInterpreter();

        if (context.getInstrumentedSourceSection().getCharacters().toString().startsWith(providedMethod + "(")) {
            method_speedUp_count++;
            busyWaitMircros(speedUp);
        }
        else{
            method_slowed_count++;
            busyWaitMircros(slowdown);
            
        }
        
    }

    @Override
    public void onReturnExceptional(EventContext context, VirtualFrame frame, Throwable exception) {
        // TODO Auto-generated method stub
        
    }

    public static void busyWaitMircros (final long micros) {
        
         final long waitUntil = System.nanoTime() + (1000 * micros);
        while (waitUntil > System.nanoTime()) {
            Thread.onSpinWait();
        }  
        
    }
    
    public int get_speedUp_count() {
        return method_speedUp_count;      
    }
    public int get_slowed_count() {
        return method_slowed_count;      
    }
}
