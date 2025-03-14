package kks.lend36back.persistence.internship;

import jakarta.validation.Valid;

import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

   public interface InternshipMapper {

        @Mapping(source = "title", target = "title")
        @Mapping(source = "description", target = "description")
        @Mapping(source = "name", target = "name")
        @Mapping(source = "email", target = "email")
        Internship toInternship(InternshipDto internshipDto);

        @Mapping(source = "title", target = "title")
        @Mapping(source = "description", target = "description")
        @Mapping(source = "name", target = "name")
        @Mapping(source = "email", target = "email")
        Internship addNewInternship(InternshipDto internshipDto, @MappingTarget Internship internship);

          List<InternshipDto> toInternship (List<Internship> internships);


}
