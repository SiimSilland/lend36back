package kks.lend36back.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    INCORRECT_EMAIL("Ei leitud emaili registreeritute nimekirjast", 112),
    COMPANY_USER_NOT_FOUND( "Ei leitud firma kasutaja ID",  303),
    NO_COMPANY_FOUND("Ei leitud ühtegi firma", 222),
    COMPANY_NUMBER_IN_USE("Sellise numbriga firma on juba registreeritud", 444),
    PRIMARY_KEY_NOT_FOUND("Ei leidnud primary keyd: ", 888),
    FOREIGN_KEY_NOT_FOUND("Ei leidnud foreign keyd: ", 999);

    private final String message;
    private final int errorCode;
}
