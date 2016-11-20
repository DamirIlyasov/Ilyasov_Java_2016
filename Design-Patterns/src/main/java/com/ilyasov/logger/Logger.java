package com.ilyasov.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Logger {
    protected Pattern pattern;
    protected Logger next;
    protected String regex;
    public void setNext(Logger next) {
        this.next = next;
    }
    public void setRegex(String regex){
        this.regex = regex;
    }

    public void setPattern() {
        this.pattern = Pattern.compile(regex);
    }

    public void log(String message) {
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            writeMessage(message.substring(message.indexOf("[",2),message.length()));
        }
        if (next != null) {
            next.log(message);
        }
    }



    void writeMessage(String message) {
        System.out.println(message);
    }
}