import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoLogger extends Logger {
    public InfoLogger(){
        this.level = "INFO";
    }
    @Override
    public void log(String message) {
        Pattern pattern = Pattern.compile("\\[(INFO|ERROR)\\] : \\[.+\\]");
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()){
            writeMessage(message);
        }
        if (next != null){
            next.log(message);
        }
    }
}