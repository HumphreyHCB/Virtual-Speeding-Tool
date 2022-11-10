package com.oracle.truffle.st;

import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;

class EventFactory implements ExecutionEventNodeFactory {


    private final Env env;
    private final long slowdown;
    private final long speedUp;
    private final String providedMethod;

    EventFactory(final Env env, final long slowdown, final long speedUp, final String providedMethod) {
        this.env = env;
        this.slowdown = slowdown;
        this.speedUp = speedUp;
        this.providedMethod = providedMethod;
    }


    public ExecutionEventNode create(final EventContext ec) {
        if ( slowdown  <= 0) {    
            return null;           
        }
        if (ec.getInstrumentedSourceSection().getCharacters().toString().startsWith(providedMethod + "("))
        {
            return new SlowEventNode(speedUp);
        }
        else{
            return new SlowEventNode(slowdown);
        }
        
    }

}