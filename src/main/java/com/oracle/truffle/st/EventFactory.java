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


    private final VirtuallySpeedingTool virtuallySpeedingTool;
    private final Env env;

    EventFactory(VirtuallySpeedingTool virtuallySpeedingTool, final Env env) {
        this.virtuallySpeedingTool = virtuallySpeedingTool;
        this.env = env;
    }
    
    
    public ExecutionEventNode create(final EventContext ec) {
        final PrintStream out = new PrintStream(env.out());
        return new ExecutionEventNode() {


            @Override
            public void onReturnValue(VirtualFrame vFrame, Object result) {
                
            }

            
        };
        
    }
    public ExecutionEventListener myListener = new ExecutionEventListener() {

        @Override
        public void onReturnValue(EventContext context, VirtualFrame frame, Object result) {
          String callSrc = (String) context.getInstrumentedSourceSection().getCharacters();
          // is this the function call that we want to modify?
          if ("testPrint()".equals(callSrc)) {
            CompilerDirectives.transferToInterpreter();
            // notify the runtime that we will change the current execution flow
            throw context.createUnwind(null);
          }
        }
      
        @Override
        public Object onUnwind(EventContext context, VirtualFrame frame, Object info) {
          // just return 42 as the return value for this node
          System.out.println("function was unwinded");
          return null;
        }

        @Override
        public void onEnter(EventContext context, VirtualFrame frame) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void onReturnExceptional(EventContext context, VirtualFrame frame, Throwable exception) {
            // TODO Auto-generated method stub
            
        }
      };

}