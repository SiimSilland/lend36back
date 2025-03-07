package kks.lend36back.persistence.company_profile;

import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfile;
import kks.lend36back.status.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

public interface CompanyProfileMapper {

    CompanyProfile toCompanyProfile(NewCompanyDto newCompany);

    List<NewCompanyProfile> toCompanyProfiles(List<CompanyProfile> companyProfiles);

    @Mapping(source = "companyName", target = "name")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(constant = "", target = "description")
    @Mapping(constant = "", target = "www")
    @Mapping(constant = "", target = "address")
    CompanyProfile toNewCompany(NewCompanyDto newCompanyDto );

    List<NewCompanyProfile> getCompanyProfiles(List<CompanyProfile> companyProfiles);

    CompanyProfile toCompanyProfile(NewCompanyProfile newCompanyProfile);
}


