package kks.lend36back.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    PENDING("P"),
    ACTIVE("A"),
    DELETED("D");

    private final String code;

}
