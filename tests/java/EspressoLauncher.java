package launchers;


import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
class EspressoLauncher {
    public static void main(String[] args) {
        try(Context ctx = Context.newBuilder("js", "java")
                .allowAllAccess(true)
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .build()) {
            Value bindings = ctx.eval("java", "<Bindings>"); // ctx.getBindings("java");
            Value main = bindings.getMember("java.lang.Math");
            System.out.println(main.execute());
           
        }
    }
}