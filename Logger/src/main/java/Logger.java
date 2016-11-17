import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Logger {
    protected String level;
    protected Logger next;
    protected String regularExpression;

    public void setNext(Logger next) {
        this.next = next;
    }

    public void log(String message) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            writeMessage(matcher.group("message"));
        }
        if (next != null) {
            next.log(message);
        }
    }


    void writeMessage(String message) {
        System.out.println(message);
    }
}