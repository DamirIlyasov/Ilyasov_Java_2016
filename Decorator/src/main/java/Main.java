import java.io.*;

/**
 * Created by damir on 15.11.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Text.txt");
        Reader is = new RandomCaseInputStream(new FileReader(file));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }
}
