package kks.lend36back.controller.student.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.student_profile.StudentProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link StudentProfile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileDto implements Serializable {

    @NotNull
    @Size(max = 255)
    private String firstName;

    @NotNull
    @Size(max = 255)
    private String lastName;

    @Size(max = 255)
    private String address;

    @Size(max = 255)
    private String phone;

    @Size(max = 255)
    private String linkedin;

    @NotNull
    @Size(max = 255)
    private String email;
}