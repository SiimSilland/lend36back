package kks.lend36back.controller.student.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStudent implements Serializable {

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String password;


}