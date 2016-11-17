import java.io.*;

/**
 * Created by aleksandrpliskin on 09.11.16.
 */
public class UpperCaseReader extends FilterReader {

  public UpperCaseReader(Reader reader) {
    super(reader);
  }

  @Override
  public int read() throws IOException {
    int c = super.read();
    return c == -1 ? c : Character.toUpperCase(c);
  }

  
}
