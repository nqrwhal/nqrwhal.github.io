import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

public class MarkdownParse {

    public static ArrayList<String> getLinks(List<String> d) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (String x : d) {
            if (x.contains("[") && x.contains("]") && x.contains("(") && x.contains(")")) {
                char[] y = x.toCharArray();
                int closeParen = 0;

                int i = 0;
                for (char z : y) {
                    i++;
                    if (Character.toString(z) == "[") {
                        int j = i;
                        for (j++; j < y.length; ) {
                            if (j != 1 && Character.toString(y[j]) == "]") {
                                if (Character.toString(y[j + 1]) == "(") {
                                    for (int k = j + 2; k < y.length; k++) {
                                        if (Character.toString(y[k]) == ")") {
                                            int openParen = j + 1;
                                            closeParen = k;
                                            toReturn.add(x.substring(openParen + 1, closeParen));
                                            i = 0;
                                            break;
                                        }
                                    }

                                }
                            }
                            break;
                        }
                    }
                    char[] c = new char[y.length - closeParen];
                    int q = 0;
                    for (int l = closeParen; l < y.length; l++) {
                        c[q] = y[l];
                        q++;
                    }
                    y = c;
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