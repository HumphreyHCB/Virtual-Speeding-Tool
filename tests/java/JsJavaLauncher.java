package launchers;

import org.graalvm.polyglot.Context;

public class JsJavaLauncher {
    public static void main(String[] args) {
        Launch();
    }

    // private static void Launch() {
    //     Context ctx = Context.newBuilder("js", "java")
    //             .allowAllAccess(true)
    //             .option("Virtually-Speeding-Tool", "true")
    //             .option("Virtually-Speeding-Tool.Slowdown-amount", "100000")
    //             .option("Virtually-Speeding-Tool.speed-up-Method", "moveDisks")
    //             .build();
    //     ctx.eval("js", "let Harness = Polyglot.eval('java','code.Harness'); Harness.main(['Towers','10','1'])");
    // }
    private static void Launch() {
        Context ctx = Context.newBuilder("js", "java")
                .allowAllAccess(true)
                .allowHostAccess(true)
                .option("Virtually-Speeding-Tool", "true")
                .option("Virtually-Speeding-Tool", "true")
                .option("Virtually-Speeding-Tool.Slowdown-amount", "1000")
                .option("Virtually-Speeding-Tool.speed-up-Method", "moveDisks")
                .build();
        ctx.eval("js", "let Harness = Polyglot.eval('java','code.Harness'); Harness.main(['Towers','10','1'])");
    }
}
