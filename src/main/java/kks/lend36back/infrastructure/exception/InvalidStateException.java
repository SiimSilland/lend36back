package kks.lend36back.infrastructure.exception;

import lombok.Getter;

@Getter
public class InvalidStateException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public InvalidStateException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}

