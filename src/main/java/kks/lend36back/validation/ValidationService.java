package kks.lend36back.validation;

import jakarta.validation.ValidationException;
import kks.lend36back.infrastructure.exception.DataNotFoundException;
import kks.lend36back.infrastructure.exception.DuplicationResourceException;
import kks.lend36back.infrastructure.exception.InvalidStateException;
import kks.lend36back.persistence.company_profile.CompanyProfile;
// import kks.lend36back.persistence.location.Location;

import java.util.List;

import static kks.lend36back.infrastructure.Error.*;

public class ValidationService {

    public static DataNotFoundException throwPrimaryKeyNotFoundException(String primaryKeyName, Integer value) {
        return new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage() + primaryKeyName + " = " + value, PRIMARY_KEY_NOT_FOUND.getErrorCode());
    }

    public static DataNotFoundException throwForeignKeyNotFoundException(String fieldName, Integer value) {
        return new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage() + fieldName + " = " + value, FOREIGN_KEY_NOT_FOUND.getErrorCode());
    }

    public static DataNotFoundException throwNotFoundException(String fieldName, String value) {
        return new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage() + fieldName + " = " + value, FOREIGN_KEY_NOT_FOUND.getErrorCode());
    }

    public static InvalidStateException throwGroupNotEmptyException() {
        return new InvalidStateException(GROUP_NOT_EMPTY.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode());
    }
    public static ValidationException validationException(){
        return new ValidationException();
    }

}
