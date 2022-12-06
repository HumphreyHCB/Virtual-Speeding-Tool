package launchers;

import code.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class EspressoLauncher {
    public static void main(String[] args) {
        try(Context ctx = Context.newBuilder("java", "js")
                .option("Virtually-Speeding-Tool", "true")
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .option("java.Classpath", "/home/hburchell/Repos/Virtual-Speeding-Tool/classes")
                .allowAllAccess(true)
                .build()) {

            Value bindings = ctx.getBindings("java");
            Value harness = bindings.getMember("code.Harness");
            System.out.println(harness);        

   


           
        }
    }
}

//ctx.getBindings("js").putMember("harness", new Harness());
//System.out.println(ctx.eval("js", "harness.printUsage();"));
