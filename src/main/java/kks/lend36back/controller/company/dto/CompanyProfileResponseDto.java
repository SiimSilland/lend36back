package kks.lend36back.controller.company.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link CompanyProfile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyProfileResponseDto implements Serializable {
        private String name;
        private String registrationNumber;
        private String description;
        private String www;
       private String address;
       private String phone;
}