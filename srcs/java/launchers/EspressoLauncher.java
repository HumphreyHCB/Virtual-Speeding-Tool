package launchers;

import tool.Harness;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;


public class EspressoLauncher {
    public static void main(String[] args) {

        new EspressoLauncher().LaunchFilewithLineActivation(args[0]);
           
        
    }

    public void LaunchFilewithLineActivation(String javaProgram) {
        try(Context ctx = Context.newBuilder("java", "js")
        .option("Virtually-Speeding-Tool", "true")
        .option("java.Classpath", new JSONObject(Files.readString(Path.of("env.json"))).getString("Classes-Path"))
        .option("java.MultiThreaded", "true")
        .option("engine.MultiTier", "true")
        .option("engine.DynamicCompilationThresholds", "false")
        .option("engine.SingleTierCompilationThreshold", "253")
        .option("engine.CompilationFailureAction", "ExitVM")
        .allowAllAccess(true)
        .allowExperimentalOptions(true)
        .build()) {

    Value bindings = ctx.getBindings("java");
    Value harness = bindings.getMember("tool.Harness");
    harness.invokeMember("main", (Object) new Object[]{javaProgram, "1", "1", "no longer used", new JSONObject(Files.readString(Path.of("env.json"))).getString("write-Path")});       

    }catch (Exception e) {
        e.printStackTrace();
        // TODO: handle exception
    }
    }

    public void LaunchFileWithTool(String javaProgram, String slowdownAmount, String slowdownMethod) {
            try(Context ctx = Context.newBuilder("java", "js")
            .option("Virtually-Speeding-Tool", "true")
            .option("Virtually-Speeding-Tool.Slowdown-amount", slowdownAmount)
            .option("Virtually-Speeding-Tool.speed-up-Method", slowdownMethod)
            .option("java.Classpath", new JSONObject(Files.readString(Path.of("env.json"))).getString("Classes-Path"))
            .option("java.MultiThreaded", "true")
            .option("engine.MultiTier", "true")
            .option("engine.DynamicCompilationThresholds", "false")
            .option("engine.SingleTierCompilationThreshold", "253")
            .option("engine.CompilationFailureAction", "ExitVM")
            .allowAllAccess(true)
            .allowExperimentalOptions(true)
            .build()) {

        Value bindings = ctx.getBindings("java");
        Value harness = bindings.getMember("tool.Harness");
        harness.invokeMember("main", (Object) new Object[]{javaProgram, "50", "1", slowdownMethod, new JSONObject(Files.readString(Path.of("env.json"))).getString("write-Path")});       

        }catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        
    }

    public void LaunchFileWithTool(String javaProgram, String slowdownAmount, String slowdownMethod, String lineNumber) {
        try(Context ctx = Context.newBuilder("java", "js")
        .option("Virtually-Speeding-Tool", "true")
        .option("Virtually-Speeding-Tool.Slowdown-amount", slowdownAmount)
        .option("Virtually-Speeding-Tool.speed-up-Method", slowdownMethod)
        .option("Virtually-Speeding-Tool.Enable-Line-Slowdown", "true")
        .option("Virtually-Speeding-Tool.Line-Number", lineNumber)
        .option("java.Classpath", new JSONObject(Files.readString(Path.of("env.json"))).getString("Classes-Path"))
        .option("java.MultiThreaded", "true")
        .option("engine.MultiTier", "true")
        .option("engine.DynamicCompilationThresholds", "false")
        .option("engine.SingleTierCompilationThreshold", "253")
        .option("engine.CompilationFailureAction", "ExitVM")
        .allowAllAccess(true)
        .allowExperimentalOptions(true)
        .build()) {

    Value bindings = ctx.getBindings("java");
    Value harness = bindings.getMember("tool.Harness");
    harness.invokeMember("main", (Object) new Object[]{javaProgram, "50", "1", slowdownMethod, new JSONObject(Files.readString(Path.of("env.json"))).getString("write-Path")});       

    }catch (Exception e) {
        e.printStackTrace();
        // TODO: handle exception
    }

    
}
}

