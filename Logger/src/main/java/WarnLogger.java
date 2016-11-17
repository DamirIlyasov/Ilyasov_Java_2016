import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WarnLogger extends Logger {
    public WarnLogger() {
        this.level = "WARN";
    }

    @Override
    public void log(String message) {
        Pattern pattern = Pattern.compile("\\[WARN\\] : \\[.+\\]");
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()){
            writeMessage(message);
        }
        if (next != null){
            next.log(message);
        }

    }
}