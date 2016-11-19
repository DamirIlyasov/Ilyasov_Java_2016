package com.ilyasov.logger;

public class InfoLogger extends Logger {
    private String regex = Level.INFO.toString();

    public InfoLogger() {
        this.setRegex(regex);
    }

}