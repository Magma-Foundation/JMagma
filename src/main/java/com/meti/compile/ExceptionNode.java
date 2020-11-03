package com.meti.compile;

public class ExceptionNode implements Node {
    private final String message;
    private final Exception exception;

    public ExceptionNode(String message, Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    @Override
    public boolean is(Group group) {
        return false;
    }

    @Override
    public String render() {
        throw new IllegalStateException(message, exception);
    }
}