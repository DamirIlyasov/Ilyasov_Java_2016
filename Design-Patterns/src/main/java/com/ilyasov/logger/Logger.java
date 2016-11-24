package com.ilyasov.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Logger {
    private Pattern pattern;
    private Logger next;

    void setNext(Logger next) {
        this.next = next;
    }

    void setLevel(String level) {
        this.pattern = Pattern.compile("\\[+" + level + "\\].*");
    }

    void log(String message) {
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            System.out.println(message.substring(message.indexOf("[", 2), message.length()));
        }
        if (next != null) {
            next.log(message);
        }
    }
}