package com.ilyasov.logger;

public enum Level {
    WARN("\\[WARN\\].*"),
    ERROR("\\[ERROR\\].*"),
    INFO("\\[(INFO|ERROR)\\].*")
    ;

    private final String text;
    Level(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
