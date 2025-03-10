package kks.lend36back.infrastructure.exception;


import lombok.Getter;

@Getter
public class DuplicationResourceException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public DuplicationResourceException(String message, Integer errorCode ) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
