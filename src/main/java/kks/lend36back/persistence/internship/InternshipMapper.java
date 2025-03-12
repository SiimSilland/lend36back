package kks.lend36back.persistence.internship;

import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

   public interface InternshipMapper {

        @Mapping(source = "title", target = "title")
        @Mapping(source = "description", target = "description")
        @Mapping(source = "coordinatorName", target = "coordinatorName")
        @Mapping(source = "coordinatorEmail", target = "coordinatorEmail")
        @Mapping(target = "companyUser", ignore = true) //
        Internship toInternship(InternshipDto internshipDto);

        List<InternshipDto> toInternship (List<Internship> internships);


}
