package kks.lend36back.persistence.company_profile;

import kks.lend36back.controller.company.dto.CompanyProfileResponseDto;
import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfileDto;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface CompanyProfileMapper {

    CompanyProfile toCompanyProfile(NewCompanyDto newCompany);

    CompanyProfile toCompanyProfile(NewCompanyProfileDto newCompanyProfileDto); // ✅ FIXED

    @Mapping(source = "companyName", target = "name")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(constant = "", target = "description")
    @Mapping(constant = "", target = "www")
    @Mapping(constant = "", target = "address")
    @Mapping(constant = "", target = "phone")
    CompanyProfile toNewCompany(NewCompanyDto newCompanyDto);

    @Mapping(source = "name", target = "companyName")
    @Mapping(source = "www", target = "www")
    CompanyProfileResponseDto toCompanyProfileResponseDto(CompanyProfile companyProfile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "www", target = "www")
    void updateCompanyProfile(NewCompanyProfileDto newCompanyProfileDto, @MappingTarget CompanyProfile companyProfile);
}

