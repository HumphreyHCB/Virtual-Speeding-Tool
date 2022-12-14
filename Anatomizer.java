import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.oracle.truffle.api.TruffleFile;
import com.oracle.truffle.api.instrumentation.SourceSectionFilter;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.source.Source.SourceBuilder;

import org.graalvm.polyglot.io.FileSystem;

public class Anatomizer {

    String fileName;
    
    public Anatomizer(String fileName){

        fileName = this.fileName;

    }

    public static String[] findMethonds(String fileName) throws IOException, URISyntaxException
    {

        System.out.println("in method");
        File file = new File(fileName);
        URI uri = new URI(fileName);
        URL url = file.toURI().toURL();
        Source source = Source.newBuilder("java", url).build();
        SourceSectionFilter.Builder builder = SourceSectionFilter.newBuilder();
        SourceSectionFilter filter1 = builder.sourceIs(source).tagIs(CallTag.class).build();
        String a = filter1.toString();
        String[] foo = new String[]{ "a", "b", "c" } ;
        
        return foo;
        
    }

    public static void main(String[] args) throws URISyntaxException {
        try {
            String[] foo2 = findMethonds("/home/hburchell/Repos/testing/my-app/test.java");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}