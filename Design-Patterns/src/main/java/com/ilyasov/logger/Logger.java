package com.ilyasov.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Logger {
    private Pattern pattern;
    private Logger next;
    private String regex;

    public void setNext(Logger next) {
        this.next = next;
    }

    protected void setRegex(String regex) {
        this.regex = regex;
    }

    protected void setPattern() {
        this.pattern = Pattern.compile(regex);
    }

    public void log(String message) {
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            System.out.println(message.substring(message.indexOf("[", 2), message.length()));
        }
        if (next != null) {
            next.log(message);
        }
    }
}