public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.regularExpression = "\\[ERROR\\] : (?<message>\\[.+\\])$";
    }

}

