package launchers;

import tool.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;


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
            .option("java.Classpath", new JSONObject(Files.readString(Path.of("env.json"))).getString("Classes-Path"))
            .option("java.MultiThreaded", "false") // JS is single-threaded
            .allowAllAccess(true)
            .allowExperimentalOptions(true)
            .build()) {

        Value bindings = ctx.getBindings("java");
        Value harness = bindings.getMember("tool.Harness");
        harness.invokeMember("main", (Object) new Object[]{javaProgram, "500", "1", slowdownMethod, new JSONObject(Files.readString(Path.of("env.json"))).getString("write-Path")});       

        }catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}

