import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoLogger extends Logger {
    public InfoLogger(){
        this.level = "INFO";
    }
    @Override
    public void log(String message) {
//        String[] s = message.split(" : ");
//        level = s[0];
//        if (level.equals("[INFO]") || level.equals("[ERROR]")) {
//            String text = s[1];
//            writeMessage(text);
//
//        }
//        if (next != null) {
//            next.log(message);
//        }
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