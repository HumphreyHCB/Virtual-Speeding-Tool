package launchers;

import org.graalvm.polyglot.Context;

public class JsJavaLauncher {
    public static void main(String[] args) {
        Launch();
    }

    private static void Launch() {
        Context ctx = Context.newBuilder("js")
                .allowAllAccess(true)
                .option("Virtually-Speeding-Tool", "true")
                .build();
        ctx.eval("js", "let helloMain = Java.type('hello.Main'); helloMain.main(null)");
    }
}