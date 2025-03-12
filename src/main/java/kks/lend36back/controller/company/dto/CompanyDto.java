package kks.lend36back.controller.company.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    @NotNull
    private String companyName;

    @NotNull
    @Size(max = 30)
    private String registrationNumber;

    @NotNull
    private String description;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @NotNull
    private String www;
}
