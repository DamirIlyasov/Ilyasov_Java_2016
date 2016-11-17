import java.io.*;

/**
 * Created by damir on 15.11.16.
 */
public class LowerCaseInputStream extends FilterReader {
    public LowerCaseInputStream(Reader reader) throws FileNotFoundException {
        super(reader);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c==-1?c:Character.toLowerCase(c);
    }
}
