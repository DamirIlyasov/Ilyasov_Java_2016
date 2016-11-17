import java.io.*;
import java.util.Random;

/**
 * Created by damir on 15.11.16.
 */
public class RandomCaseReader extends FilterReader{

    protected RandomCaseReader(Reader reader) {
        super(reader);
    }
    Random a = new Random();
    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1? c : a.nextInt() % 2 == 1? Character.toUpperCase(c) : Character.toLowerCase(c);
    }
}
