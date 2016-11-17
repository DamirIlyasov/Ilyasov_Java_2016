public class WarnLogger extends Logger {
    public WarnLogger() {
        this.level = "WARN";
        this.regularExpression = "\\[WARN\\] : (?<message>\\[.+\\])$";
    }
}