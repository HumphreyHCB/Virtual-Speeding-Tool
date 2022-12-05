package launchers;

import code.Harness;


import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


class EspressoLauncher {
    public static void main(String[] args) {
        try(Context ctx = Context.newBuilder("js", "java")
                .allowAllAccess(true)
                .option("java.MultiThreaded", "false") // JS is single-threaded
                .build()) {
            Value bindings = ctx.eval("java", "<Bindings>"); // ctx.getBindings("java");
            Harness harnessobject = Class.forName("code.Harness");
            System.out.println(harnessobject);
            Value harness = bindings.getMember(harnessobject.getClass().getName());
            System.out.println(harness);
            System.out.println(harness.canExecute());
            //Value main = bindings.getMember(harness.getClass());
            //System.out.println(main.execute());
           
        }
    }
}