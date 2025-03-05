package kks.lend36back.controller.admin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.group_email.GroupDto;
import kks.lend36back.persistence.group_email.GroupEmail;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link GroupEmail}
 */
@Value
public class NewGroupEmail implements Serializable {
    @NotNull
    GroupDto group;
    @NotNull
    @Size(max = 255)
    String firstName;
    @NotNull
    @Size(max = 255)
    String lastName;
    @NotNull
    @Size(max = 255)
    String email;
    @NotNull
    @Size(max = 1)
    String status;
}