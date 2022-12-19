package launchers;

import code.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class EspressoLauncher {
    public static void main(String[] args) {
        // args0 = slowdown-amount
        // args1 = method
        // args2 = java file
        try(Context ctx = Context.newBuilder("java", "js")
                .option("Virtually-Speeding-Tool", "true")
                .option("java.Classpath", "/home/hburchell/Repos/Virtual-Speeding-Tool/classes")
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .allowAllAccess(true)
                .allowExperimentalOptions(true)
                .build()) {

            // Value bindings = ctx.getBindings("java");
            // Value harness = bindings.getMember("code.Harness");
            // harness.invokeMember("main", (Object) new Object[]{"badBubbles", "1000", "1"});       


           
        }
    }

    public void LaunchFileWithTool(String javaProgram, String slowdownAmount, String slowdownMethod) {
            try(Context ctx = Context.newBuilder("java", "js")
            .option("Virtually-Speeding-Tool", "true")
            .option("Virtually-Speeding-Tool.Slowdown-amount", slowdownAmount)
            .option("Virtually-Speeding-Tool.speed-up-Method", slowdownMethod)
            .option("java.Classpath", "/home/hburchell/Repos/Virtual-Speeding-Tool/classes")
            .option("java.MultiThreaded", "false") // JS is single-threaded
            .allowAllAccess(true)
            .allowExperimentalOptions(true)
            .build()) {

        Value bindings = ctx.getBindings("java");
        Value harness = bindings.getMember("code.Harness");
        harness.invokeMember("main", (Object) new Object[]{javaProgram, "1000", "1"});       

        }
    }
}

