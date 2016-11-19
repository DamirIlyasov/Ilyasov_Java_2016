package com.ilyasov.logger;

public class ErrorLogger extends Logger {
    private String regex = Level.ERROR.toString();


    public ErrorLogger() {
        this.setRegex(regex);
    }

}

