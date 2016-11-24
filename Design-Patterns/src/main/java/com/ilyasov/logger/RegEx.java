package com.ilyasov.logger;

public enum RegEx {
    WARN("\\[WARN\\].*"),
    ERROR("\\[ERROR\\].*"),
    INFO("\\[(INFO|ERROR)\\].*");

    private final String text;

    RegEx(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
