// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if(nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }

            else if(markdown.substring(nextOpenBracket + 1, nextCloseBracket).indexOf("\n") != -1){
                currentIndex = closeParen + 1;
            }

            else if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket-1) == '!'){
                currentIndex = closeParen + 1;
            }

            else if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket-1) == '`'){
                currentIndex = closeParen + 1;
            }

            else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }

        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        // Map<String, List<String>> file;
        // fileContents = file.
        // ArrayList<String> links;
        // if(new File(args[0]).isDirectory()){
        //     fileContents = getLinks(new File(args[0]));
        //     System.out.println(fileContents);
        // }
		// else{
        //     Path fileName = Path.of(args[0]);
	    //     String contents = Files.readString(fileName);
        //     links = getLinks(contents);
        //     System.out.println(links);
        // }

            Path fileName = Path.of(args[0]);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = getLinks(contents);
            System.out.println(links);
    }
}