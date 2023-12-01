package com.example.chatService.exception;

public class NullJwtTokenException extends RuntimeException{
    private final ExceptionList exceptionList;

    public NullJwtTokenException(ExceptionList exceptionList) {
        super(exceptionList.getMessage());
        this.exceptionList = exceptionList;
    }

    public ExceptionList getExceptionList() {
        return exceptionList;
    }
}
