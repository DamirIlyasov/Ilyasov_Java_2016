package com.ilyasov.logger;

public class WarnLogger extends Logger {
    private String regex = RegEx.WARN.toString();

    public WarnLogger() {
        this.setRegex(regex);
        this.setPattern();
    }

}