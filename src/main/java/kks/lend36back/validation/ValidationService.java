package kks.lend36back.validation;

import kks.lend36back.infrastructure.exception.DataNotFoundException;
// import kks.lend36back.persistence.location.Location;

import java.util.List;

import static ee.bcs.bank36back.infrastructure.Error.*;

public class ValidationService {

    public static DataNotFoundException throwPrimaryKeyNotFoundException(String primaryKeyName, Integer value) {
        return new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage() + primaryKeyName + " = " + value, PRIMARY_KEY_NOT_FOUND.getErrorCode());
    }

    public static DataNotFoundException throwForeignKeyNotFoundException(String fieldName, Integer value) {
        return new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage() + fieldName + " = " + value, FOREIGN_KEY_NOT_FOUND.getErrorCode());
    }

    public static void validateAtLeastOneLocationExists(List<Location> locations) {
        if (locations.isEmpty()) {
            throw new DataNotFoundException(NO_LOCATION_FOUND.getMessage(), NO_LOCATION_FOUND.getErrorCode());
        }
    }

}
