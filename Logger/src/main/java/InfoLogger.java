public class InfoLogger extends Logger {
    public InfoLogger(){
        this.level = "INFO";
        this.regularExpression = "\\[(INFO|ERROR)\\] : (?<message>\\[.+\\])$";
    }

}