import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 3);
    }

    // @Test
    // public void testMarddownParse() throws IOException {
    //     Path fileName = Path.of("another-file.md");
	//     String contents = Files.readString(fileName);

    //     assertEquals(List.of("https://cse15L9amLab.com", "https://hahahah.html/subpage"), MarkdownParse.getLinks(contents) );

    // }

}