package com.ilyasov.logger;

public class InfoLogger extends Logger {

    public InfoLogger() {
        setLevel("("+Level.INFO + "|" + Level.ERROR+")");
    }

}