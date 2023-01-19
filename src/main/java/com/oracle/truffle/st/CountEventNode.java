package com.oracle.truffle.st;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;

public class CountEventNode extends ExecutionEventNode{
    int counter = 0;
    final int lineNumber;

    public CountEventNode(final int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    @Override
    public void onEnter(final VirtualFrame frame) {    
    counter++; 
    }

}
