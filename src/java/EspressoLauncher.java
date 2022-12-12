package launchers;

import code.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class EspressoLauncher {
    public static void main(String[] args) {
        // args0 = slowdown-amount
        // args1 = method
        try(Context ctx = Context.newBuilder("java", "js")
                .option("Virtually-Speeding-Tool", "true")
                .option("Virtually-Speeding-Tool.Slowdown-amount", args[0])
                .option("Virtually-Speeding-Tool.speed-up-Method", args[1])
                .option("java.Classpath", "/home/hburchell/Repos/Virtual-Speeding-Tool/classes")
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .allowAllAccess(true)
                .allowExperimentalOptions(true)
                .build()) {

            Value bindings = ctx.getBindings("java");
            Value harness = bindings.getMember("code.Harness");
            harness.invokeMember("main", (Object) new Object[]{"sortingtest", "1000", "1"});       


           
        }
    }
}

//ctx.getBindings("js").putMember("harness", new Harness());
//System.out.println(ctx.eval("js", "harness.printUsage();"));
