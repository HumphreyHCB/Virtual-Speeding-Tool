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
    
    @Option(name = "speed-up-Method", help = "Select which method you whish to be speed up", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<String> speedUpMethod = new OptionKey<>("");

    @Option(name = "Percentage-of-speedUp", help = "The amount of speed up you whish to apply to the method you wish to speed up (%)", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Integer> PercentageofspeedUp = new OptionKey<>(0);

    @Option(name = "Amount-of-Slowdown", help = "The amount of time you want to slow down all methods (µs)", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Integer> AmountofSlowdown = new OptionKey<>(0);
    
    public static final String ID = "Virtually-Speeding-Tool";

    static int method_slowed_count = 0;
    static int method_speedUp_count = 0;
    int slowdown;
    double speedUp;
    String providedMethod;

    @Override
    protected void onCreate(final Env env) {

        if (env.getOptions().get(speedUpMethod).toString().equals("")) {
            System.out.println("A method to speed up has not been provided.");
        }
        providedMethod = env.getOptions().get(speedUpMethod).toString();
        if (env.getOptions().get(AmountofSlowdown).equals(0)) {
            System.out.println("No slowdown has been provided, instrumentation will still be placed but no speeding up or slow down will occur beyond the overhead of placing the instrumentation");
        }

        try {
            slowdown = (env.getOptions().get(AmountofSlowdown).intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        speedUp = ( env.getOptions().get(PercentageofspeedUp) / 100 ) * slowdown;


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
        System.out.println("\n--------------------------------");
        //System.out.println("Instrumented Program : "+env.getTruffleFile(ID));
        System.out.println("Amount of slowness (µs) : " + env.getOptions().get(AmountofSlowdown) + "µs");
        System.out.println("Virtually speed up method : " + env.getOptions().get(speedUpMethod));
        System.out.println("Percentage of speedUp (%) : " + env.getOptions().get(PercentageofspeedUp));
        System.out.println("The amount of times slowed down occured : " + method_slowed_count);
        System.out.println("The amount of times speed up occured : " + method_speedUp_count);
        System.out.println("--------------------------------\n"); 
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
        public void onEnter(EventContext context, VirtualFrame frame) {
            String callSrc = (String) context.getInstrumentedSourceSection().getCharacters();
            if ( slowdown  <= 0) {return;}
            
            if (callSrc.equals(providedMethod)) {
                method_speedUp_count++;
                try {
                    Thread.sleep((long) speedUp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                method_slowed_count++;
                try {
                    Thread.sleep(slowdown);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
            
        }

        @Override
        public void onReturnExceptional(EventContext context, VirtualFrame frame, Throwable exception) {
            // TODO Auto-generated method stub
            
        }
      };
}

