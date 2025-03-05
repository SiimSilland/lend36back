package kks.lend36back.controller.admin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.group.Group;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Group}
 */
@Value
public class NewGroup implements Serializable {
    @NotNull
    Integer number;
    @NotNull
    @Size(max = 255)
    String period;
    @NotNull
    @Size(max = 255)
    String lectorName;
}