package com.oracle.truffle.st;

import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.PolyglotException.StackFrame;
import org.graalvm.polyglot.Context;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;
import com.oracle.truffle.api.nodes.Node;


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
        //System.out.println(getCurrentLocation().getRootName());
        //System.out.println(getCurrentLocation());


        //System.out.println(getCurrentLocation().getRootName()); <-- maybe


        //System.out.println(((Node) Truffle.getRuntime().getCallerFrame()).getEncapsulatingSourceSection().getCharacters());
        //System.out.println(ec.getInstrumentedNode().getRootNode().toString());
        //System.out.println(ec.getInstrumentedSourceSection().getCharacters().toString());
        //System.out.println(ec.getInstrumentedNode().toString());
        //System.out.println(ec.getInstrumentedNode().getParent().toString());
        //System.out.println(ec.getNodeObject().getClass().getName());
        //System.out.println(ec.getInstrumentedSourceSection().getSource());

        if (ec.getInstrumentedNode().getRootNode().toString().contains(providedMethod))
        {
           
            method_speedUp_count++;
            return new SlowEventNode(speedUp);
        }
        else{
            method_slowed_count++;
            return new SlowEventNode(slowdown);
        }
        
    }

    static StackFrame getCurrentLocation() {

        PolyglotException e = Context.getCurrent().asValue(new RuntimeException()).as(PolyglotException.class);
        for (StackFrame frame: e.getPolyglotStackTrace()) {
            if (frame.isGuestFrame()) {
                return frame;
            }
        }
        return null;
    }

}