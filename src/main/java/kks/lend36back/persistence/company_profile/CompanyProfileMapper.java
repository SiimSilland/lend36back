package kks.lend36back.persistence.company_profile;

import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.persistence.user.User;
import kks.lend36back.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

public interface CompanyProfileMapper {
    CompanyProfile toEntity(CompanyProfile companyProfile);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "registration_number", target = "registrationNumber")
    CompanyProfile toCompanyProfile (NewCompany newCompany);

    @Mapping(source = "id", target = "id")
    void idToCompanyProfile (User user);

}