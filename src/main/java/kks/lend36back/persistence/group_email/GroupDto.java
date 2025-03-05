package kks.lend36back.persistence.group_email;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kks.lend36back.persistence.group.Group}
 */
@Value
public class GroupDto implements Serializable {
    @NotNull
    Integer number;
}