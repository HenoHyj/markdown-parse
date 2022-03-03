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
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testMarddownParse() throws IOException {
        Path fileName = Path.of("another-file.md");
	    String contents = Files.readString(fileName);

        assertEquals(List.of("https://cse15L9amLab.com", "https://hahahah.html/subpage", "This is not a link", "www.google.com"), 
        MarkdownParse.getLinks(contents) );

    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
	    String contents = Files.readString(fileName);

        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
        MarkdownParse.getLinks(contents) );

        System.out.println("If you see this message, this means testSnippet1 passed.");
    }

    // @Test
    // public void testSnippet2() throws IOException {
    //     Path fileName = Path.of("snippet2.md");
	//     String contents = Files.readString(fileName);

    //     assertEquals(List.of("a.com", "a.com(())", "example.com"), 
    //     MarkdownParse.getLinks(contents) );

    //     System.out.println("If you see this message, this means testSnippet2 passed.");
    // }

    // @Test
    // public void testSnippet3() throws IOException {
    //     Path fileName = Path.of("snippet3.md");
	//     String contents = Files.readString(fileName);

    //     assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), 
    //     MarkdownParse.getLinks(contents) );

    //     System.out.println("If you see this message, this means testSnippet3 passed.");
    // }

}