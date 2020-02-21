package com.MoodMain.MoodException;

public class MoodAnalyzerException extends RuntimeException {
    public enum Exception{
        EMPTY_NULL,NOT_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,NO_SUCH_CLASS_ERROR
    }
    public Exception type;

    public MoodAnalyzerException(String message,Exception type) {
        super(message);
        this.type=type;
    }
}
