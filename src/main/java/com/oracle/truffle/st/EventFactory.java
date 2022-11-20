package com.oracle.truffle.st;

import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;


class EventFactory implements ExecutionEventNodeFactory {

    private final long slowdown;
    private final long speedUp;
    private final String providedMethod;
    public int method_speedUp_count;
    public int method_slowed_count;

    EventFactory(final Env env, final long slowdown, final long speedUp, final String providedMethod) {
        this.slowdown = slowdown;
        this.speedUp = speedUp;
        this.providedMethod = providedMethod;
         method_slowed_count = 0;
         method_speedUp_count = 0;
    }


    public ExecutionEventNode create(final EventContext ec) {
        if ( slowdown  == 0) {    
            return null;           
        }
        System.out.println(ec.getInstrumentedSourceSection().getCharacters().toString());
        //System.out.println("node object" + ec.getNodeObject());
        if (ec.getInstrumentedSourceSection().getCharacters().toString().startsWith(providedMethod + "("))
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