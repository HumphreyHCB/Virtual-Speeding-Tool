package com.oracle.truffle.st;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;


class LineEventFactory implements ExecutionEventNodeFactory {

    public List<CountEventNode> list;  

    LineEventFactory(final Env env) {

        list = new ArrayList<CountEventNode>();  
        
    }


    public ExecutionEventNode create(final EventContext ec) {

        CountEventNode line = new CountEventNode(ec.getInstrumentedNode().getSourceSection().getStartLine());
        list.add(line);
        return line;
        
    }


}