package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;

public class SlowEventNode extends ExecutionEventNode{
    long slowdown;

    public SlowEventNode(final long slowdown)
    {
        this.slowdown = slowdown;
    }

    @Override
    public void onEnter(VirtualFrame frame) {
        busyWaitMircros(slowdown);
    }

    private static void busyWaitMircros(final long micros) {
        
        final long waitUntil = System.nanoTime() + (micros);
       while (waitUntil > System.nanoTime()) {
           Thread.onSpinWait();
       }  
       
   }

}
