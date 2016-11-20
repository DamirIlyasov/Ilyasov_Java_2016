package com.ilyasov.logger;

public class InfoLogger extends Logger {
    private String regex = RegEx.INFO.toString();

    public InfoLogger() {
        this.setRegex(regex);
        this.setPattern();
    }

}