package kks.lend36back.persistence.company_profile;

import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.persistence.user.User;
import kks.lend36back.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

public interface CompanyProfileMapper {
    CompanyProfile toEntity(CompanyProfile companyProfile);
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User newCompanyToUser (NewCompany newCompany);


    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User newCompanyToUser (NewCompany newCompany);

}