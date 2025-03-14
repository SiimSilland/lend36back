package kks.lend36back.persistence.company_profile;

import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.CompanyDto;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface CompanyProfileMapper {


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "www", target = "www")
    CompanyProfile updateCompanyProfile(CompanyDto companyDto, @MappingTarget CompanyProfile companyProfile);

    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "www", target = "www")
    CompanyDto mapToCompanyProfileDto (CompanyProfile companyProfile);

    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(constant = "", target = "description")
    @Mapping(constant = "", target = "www")
    @Mapping(constant = "", target = "address")
    @Mapping(constant = "", target = "phone")
    CompanyProfile toCompanyProfile(@Valid NewCompany newCompany);

    List<NewCompany> toCompanyProfile (List<CompanyProfile> companyProfiles);
}
