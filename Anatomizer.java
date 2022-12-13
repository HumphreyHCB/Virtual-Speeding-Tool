import java.net.URL;

import com.oracle.truffle.api.instrumentation.SourceSectionFilter;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.source.Source;


public class Anatomizer {

    string fileName;
    
    public Anatomizer(string fileName){

        fileName = this.fileName;

    }

    public String[] findMethonds(string fileName)
    {
        System.out.println("in method");
        URL resource = new URL(fileName);
        Source source = Source.newBuilder("java", resource).build();
        SourceSectionFilter.Builder builder = SourceSectionFilter.newBuilder();
        SourceSectionFilter filter = builder.sourceIs(source).tagIs(CallTag.class).build();
        
    }

    public static void main(String[] args) {
        findMethonds("fillname here");
    }


}
