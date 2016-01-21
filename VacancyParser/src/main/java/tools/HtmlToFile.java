package tools;

import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Martynenko on 21.01.2016.
 */
public class HtmlToFile {
    /**
     * write temp.htmml to path /class/target/
     */
    public void writeHtmlToLocalFile(Document document){
        try (PrintWriter writer = new PrintWriter(new File(getClass().getClassLoader().getResource("temp.html").getPath()))){
            writer.write(document.outerHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
