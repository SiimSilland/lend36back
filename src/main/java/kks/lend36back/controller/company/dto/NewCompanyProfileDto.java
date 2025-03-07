package kks.lend36back.controller.company.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompanyProfileDto implements Serializable {
    @Size(max = 255)
    private String name;
    @NotNull
    @Size(max = 30)
    private String registrationNumber;
    @Size(max = 1000)
    private String description;
    @Size(max = 255)
    private String www;
    @Size(max = 225)
    private String address;
    @NotNull
    @Size(max = 25)
    private String phone;
}