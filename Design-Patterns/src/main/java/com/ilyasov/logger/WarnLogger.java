package com.ilyasov.logger;

public class WarnLogger extends Logger {
    private String regex = Level.WARN.toString();

    public WarnLogger() {
        this.setRegex(regex);
    }

}