package com.oracle.truffle.st;

import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionKey;
import org.graalvm.options.OptionStability;
import com.oracle.truffle.api.Option;
import com.oracle.truffle.api.instrumentation.Instrumenter;
import com.oracle.truffle.api.instrumentation.SourceFilter;
import com.oracle.truffle.api.instrumentation.SourceSectionFilter;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.api.source.Source;


@Registration(id = VirtuallySpeedingTool.ID,  name = "VirtuallySpeedingTool", version = "0.1")
public final class VirtuallySpeedingTool extends TruffleInstrument {

    @Option(name = "", help = "Enable Simple Coverage (default: false).", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Boolean> ENABLED = new OptionKey<>(false);
    
     @Option(name = "speed-up-Method", help = "Select which method you whish to be speed up", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<String> speedUpMethod = new OptionKey<>("#no-method-set#");

    @Option(name = "Slowdown-amount", help = "PLACEHOLDER", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Long> slowdownamount = new OptionKey<>(1000L);


/*   @Option(name = "Percentage-of-speedUp", help = "The amount of speed up you whish to apply to the method you wish to speed up (%)", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Long> PercentageofspeedUp = new OptionKey<>(0L);

    @Option(name = "Amount-of-Slowdown", help = "The amount of time you want to slow down all methods (µs)", category = OptionCategory.USER, stability = OptionStability.STABLE)
    static final OptionKey<Long> AmountofSlowdown = new OptionKey<>(0L); */
    
    public static final String ID = "Virtually-Speeding-Tool";

    private EventFactory eventFactory;
    
    @Override
    protected void onCreate(final Env env) {
/* 
        if (env.getOptions().get(speedUpMethod).toString().equals("")) {
            System.out.println("A method to speed up has not been provided.");
        }
        
        if (env.getOptions().get(AmountofSlowdown).equals(0)) {
            System.out.println("No slowdown has been provided, instrumentation will still be placed but no speeding up or slow down will occur beyond the overhead of placing the instrumentation");
        }
 */
        String providedMethod = env.getOptions().get(speedUpMethod).toString();

        // if the provide input contains the brackets and atugments we remove it
        // for example                      myMethod(1)     -->    myMethod
        if (providedMethod.contains("(")) {
            providedMethod = providedMethod.substring(0,providedMethod.indexOf("("));          
        }

        

        //final long slowdown = (env.getOptions().get(AmountofSlowdown).intValue());

        //final long speedUp = ( 100 - env.getOptions().get(PercentageofspeedUp)) / 100  * slowdown;
        final long slowdown = env.getOptions().get(slowdownamount);
        final long speedUp = 100;

        System.out.println("Custom Instrument Made");

        
        SourceFilter sf = SourceFilter.newBuilder().sourceIs((Source s) -> checkPath(s)).build();

        SourceSectionFilter.Builder builder = SourceSectionFilter.newBuilder();
        SourceSectionFilter filter = builder.sourceFilter(sf).tagIs(ExpressionTag.class).build();        
        Instrumenter instrumenter = env.getInstrumenter();
        instrumenter.attachExecutionEventFactory(filter,eventFactory = new EventFactory(env, slowdown, speedUp, providedMethod));
    }

    public boolean checkPath(Source s) {
        if (s.getPath() == null) {

        
            return s.getName().contains("Speeding");
        }
        return s.getPath().contains("Speeding");
    }


    @Override
    protected void onDispose(Env env) {       
        System.out.println("Custom Instrument Disposed"); 
        System.out.println("\n--------------------------------");
        //System.out.println("Instrumented Program : "+env.getTruffleFile(ID));
        //System.out.println("Amount of slowness (µs) : " + env.getOptions().get(AmountofSlowdown) + "µs");
        System.out.println("Virtually speed up method : " + env.getOptions().get(speedUpMethod));
        //System.out.println("Percentage of speedUp (%) : " + env.getOptions().get(PercentageofspeedUp));
        System.out.println("The amount of times slowed down occured : " + eventFactory.method_slowed_count);
        System.out.println("The amount of times speed up occured : " + eventFactory.method_speedUp_count);
        System.out.println("--------------------------------\n"); 
    }

    @Override
    protected OptionDescriptors getOptionDescriptors() {
        return new VirtuallySpeedingToolOptionDescriptors();
    }


}

