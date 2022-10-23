package com.oracle.truffle.st;

import java.util.HashSet;
import java.util.Set;

import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionKey;
import org.graalvm.options.OptionStability;
import org.graalvm.options.OptionValues;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.Option;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventListener;
import com.oracle.truffle.api.instrumentation.Instrumenter;
import com.oracle.truffle.api.instrumentation.SourceSectionFilter;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.api.source.SourceSection;


@Registration(id = VirtuallySpeedingTool.ID,  name = "VirtuallySpeedingTool", version = "0.1")
public final class VirtuallySpeedingTool extends TruffleInstrument {

    @Option(name = "", help = "Enable Simple Coverage (default: false).", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Boolean> ENABLED = new OptionKey<>(false);
    
    public static final String ID = "Virtually-Speeding-Tool";

    final Set<SourceSection> coverage = new HashSet<>();

    @Override
    protected void onCreate(final Env env) {
        System.out.println("Custom Instrument Made");
        SourceSectionFilter.Builder builder = SourceSectionFilter.newBuilder();
        SourceSectionFilter filter = builder.tagIs(ExpressionTag.class).build();
        Instrumenter instrumenter = env.getInstrumenter();
        instrumenter.attachExecutionEventFactory(filter,
                        new EventFactory(this, env));
        env.registerService(this);
        env.getInstrumenter().attachExecutionEventListener(SourceSectionFilter.newBuilder().tagIs(CallTag.class).build(), myListener);
    }

    @Override
    protected void onDispose(Env env) {       
        System.out.println("Custom Instrument Disposed");       
    }

    @Override
    protected OptionDescriptors getOptionDescriptors() {
        return new VirtuallySpeedingToolOptionDescriptors();
    }

    ExecutionEventListener myListener = new ExecutionEventListener() {

        @Override
        public void onReturnValue(EventContext context, VirtualFrame frame, Object result) {
        }
      
        @Override
        public Object onUnwind(EventContext context, VirtualFrame frame, Object info) {
          System.out.println("function was unwinded");
          return context.getNodeObject().getClass();
        }

        @Override
        public void onEnter(EventContext context, VirtualFrame frame) {
            String callSrc = (String) context.getInstrumentedSourceSection().getCharacters();
            // is this the function call that we want to modify?
            if ("testPrint()".equals(callSrc)) {
              CompilerDirectives.transferToInterpreter();
              // notify the runtime that we will change the current execution flow
              throw context.createUnwind(null);
            }
            
        }

        @Override
        public void onReturnExceptional(EventContext context, VirtualFrame frame, Throwable exception) {
            // TODO Auto-generated method stub
            
        }
      };
}

