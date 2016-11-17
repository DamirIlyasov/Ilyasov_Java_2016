import java.io.*;

/**
 * Created by damir on 15.11.16.
 */
public class SuperCaseInputStream extends FilterReader {

    int i = 0;

    public SuperCaseInputStream(Reader reader) {
        super(reader);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        i++;
        return c == -1 ? c : i % 2 == 1 ? Character.toUpperCase(c) : Character.toLowerCase(c);
    }

}
