package kks.lend36back.controller.company.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompany implements Serializable {
    @NotNull
    private String companyName;
    private String registrationNumber;
    private String email;
    private String password;
}