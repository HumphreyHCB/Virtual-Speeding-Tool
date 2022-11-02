package com.oracle.truffle.st;

import java.io.PrintStream; 

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventListener;
import com.oracle.truffle.api.instrumentation.ExecutionEventNode;
import com.oracle.truffle.api.instrumentation.ExecutionEventNodeFactory;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Env;
import com.oracle.truffle.api.source.SourceSection;

class EventFactory implements ExecutionEventNodeFactory {


    private final Env env;

    EventFactory(VirtuallySpeedingTool virtuallySpeedingTool, final Env env) {
        this.env = env;
    }


    public ExecutionEventNode create(final EventContext ec) {
        final PrintStream out = new PrintStream(env.out());
        return new ExecutionEventNode() {

            @Override
            public void onEnter(VirtualFrame frame) {
                String callSrc = (String) ec.getInstrumentedSourceSection().getCharacters();
                System.out.println("Event Factory 1 " + callSrc);
            }

            @Override
            public void onReturnValue(VirtualFrame vFrame, Object result) {

            }


        };

    }

}