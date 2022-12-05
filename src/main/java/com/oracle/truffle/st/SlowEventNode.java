package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;

public class SlowEventNode extends ExecutionEventNode{
    final long slowdown;
    volatile int counter = 0;

    public SlowEventNode(final long slowdown)
    {
        this.slowdown = slowdown;
    }

    @Override
    public void onEnter(VirtualFrame frame) {
        System.out.println("Instrumented a line");
    while (counter < slowdown) {
        counter++;
    }
    counter = 0;
    }

}
