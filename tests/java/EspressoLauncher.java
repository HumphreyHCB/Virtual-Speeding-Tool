package launchers;

import code.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class EspressoLauncher {
    public static void main(String[] args) {
        try(Context ctx = Context.newBuilder("java", "js")
                .option("Virtually-Speeding-Tool", "true")
                .option("Virtually-Speeding-Tool.Slowdown-amount", "100")
                .option("Virtually-Speeding-Tool.speed-up-Method", "moveDisks")
                .option("java.Classpath", "/home/hburchell/Repos/Virtual-Speeding-Tool/classes")
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .allowAllAccess(true)
                .allowExperimentalOptions(true)
                .build()) {

            Value bindings = ctx.getBindings("java");
            Value harness = bindings.getMember("code.Harness");
            harness.invokeMember("main", (Object) new Object[]{"Towers", "1", "1"});       


           
        }
    }
}

//ctx.getBindings("js").putMember("harness", new Harness());
//System.out.println(ctx.eval("js", "harness.printUsage();"));
