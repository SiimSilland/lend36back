package kks.lend36back.controller.company.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kks.lend36back.persistence.company_profile.CompanyProfile}
 */
@Value
public class NewCompanyProfile implements Serializable {
    String name;
    String registrationNumber;
    String description;
    String www;
    String address;
    String phone;
}