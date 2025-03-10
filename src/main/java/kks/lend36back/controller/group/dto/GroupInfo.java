package kks.lend36back.controller.group.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.group.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Group}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo implements Serializable {
    private Integer groupId;
    @NotNull
    private Integer groupNumber;
    @NotNull
    @Size(max = 255)
    private String groupPeriod;
    @NotNull
    @Size(max = 255)
    private String lectorName;
}