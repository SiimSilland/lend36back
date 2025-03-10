package kks.lend36back.persistence.company_profile;

import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.CompanyProfileResponseDto;
import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfileDto;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface CompanyProfileMapper {



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
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "description", target = "description")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "www", target = "www")
    CompanyProfile updateCompanyProfile(NewCompanyProfileDto newCompanyProfileDto, @MappingTarget CompanyProfile companyProfile);


    @Mapping(source = "description", target = "description")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "registrationNumber", target = "registrationNumber")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "www", target = "www")
    CompanyProfile toCompanyProfile(@Valid NewCompanyProfileDto newCompanyProfileDto);

    List<NewCompanyProfileDto> toCompanyProfile (List<CompanyProfile> companyProfiles);
}
