package com.ilyasov.logger;

public class ErrorLogger extends Logger {
    private String regex = RegEx.ERROR.toString();


    public ErrorLogger() {
        this.setRegex(regex);
        this.setPattern();
    }

}

