package launchers;

import code.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class EspressoLauncher {
    public static void main(String[] args) {
        try(Context ctx = Context.newBuilder("java", "js")
                .option("Virtually-Speeding-Tool", "true")
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .allowAllAccess(true)
                .build()) {


            
            ctx.getBindings("js").putMember("harness", new Harness());
            System.out.println(ctx.eval("js", "harness.printUsage();"));
            

            // might be usefull later on
            // Value harness = ctx.getBindings("js").getMember("harness");
            // Value methods = harness.getMember("getDeclaredMethods");
            // System.out.println(harness.getMemberKeys());        


           
        }
    }
}