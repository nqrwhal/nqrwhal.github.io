import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MD {

    public static ArrayList<String> getLinks(List<String> markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        for(String x: markdown) {
        	if(x.contains("[")) {
        		if(x.contains("]")) {
        			if(x.contains("(")) {
        				if(x.contains(")")) {
        					int openParen = x.indexOf("(");
        					int closeParen = x.indexOf(")");
        					toReturn.add(x.substring(openParen + 1, closeParen));
        				}
        			}continue;
        		}continue;
        	}continue;
        }
        return toReturn;
    }



    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("1.md");
        List<String> content = Files.readAllLines(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}