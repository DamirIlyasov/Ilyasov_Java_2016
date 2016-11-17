import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.level = "ERROR";
    }

    @Override
    public void log(String message) {
        Pattern pattern = Pattern.compile("\\[ERROR\\] : \\[.+\\]");
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()){
            writeMessage(message);
        }
        if (next != null){
            next.log(message);
        }
    }

}

