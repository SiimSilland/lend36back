package kks.lend36back.controller.company.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 * DTO for {@link CompanyProfile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompany implements Serializable {

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String password;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 30)
    private String registration_number;

    /*@NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    @Size(max = 255)
    private String www;
*/
}