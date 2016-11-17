public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.level = "ERROR";
        this.regularExpression = "\\[ERROR\\] : (?<message>\\[.+\\])$";
    }

}

