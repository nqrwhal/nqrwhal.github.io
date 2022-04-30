import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

public class MD {

    public static ArrayList<String> getLinks(List<String> md) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (String x : md) {
            ArrayList<String> sep = new ArrayList<String>();
            boolean j = true;
            while (j) {
                if (x.contains("[") && x.contains("]") && x.contains("(") && x.contains(")") && x.length() > 0) {

                    int a = x.indexOf("[");
                    int b = x.indexOf("]");
                    int c = x.indexOf("(");
                    int d = x.indexOf(")");
                    if (a < b && b < c && c < d) {
                        String y = x.substring(a, d);
                        sep.add(y);
                        if (d < x.length()) {
                            x = x.substring(d + 1);
                        } else {
                            break;
                        }
                    }

                }else{
                    j = false;
                }
            }
            for (String e : sep) {
                if (e.indexOf("[") + 1 != e.indexOf("]") && e.indexOf("]") + 1 == e.indexOf("(")) {
                    int openParen = e.indexOf("(");
                    
                    toReturn.add(e.substring(openParen + 1, e.length()));

                }
            }
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        List<String> content = Files.readAllLines(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
    }
}