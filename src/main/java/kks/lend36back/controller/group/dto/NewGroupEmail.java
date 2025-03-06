package kks.lend36back.controller.group.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.groupemail.GroupEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link GroupEmail}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewGroupEmail implements Serializable {
    @NotNull
    private Integer groupId;
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
    @NotNull
    @Size(max = 255)
    private String email;
}