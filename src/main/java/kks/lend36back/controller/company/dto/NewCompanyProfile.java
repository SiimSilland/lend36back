package kks.lend36back.controller.company.dto;

import kks.lend36back.persistence.company_profile.CompanyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kks.lend36back.persistence.company_profile.CompanyProfile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class NewCompanyProfile extends CompanyProfile implements Serializable {
    String companyName;
    String registrationNumber;
    String description;
    String www;
    String address;
    String phone;
}