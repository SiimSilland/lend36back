package kks.lend36back.persistence.internship;

import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

public interface InternshipMapper {
     @Mapping(source = "title", target = "title")
     @Mapping(source = "description", target = "description")
     @Mapping(source = "name", target = "name")
     @Mapping(source = "email", target = "email")
     @Mapping(target = "status", constant = "A") // ✅ Default status set
     @Mapping(target = "companyUser", ignore = true)
     Internship toInternship(InternshipDto internshipDto);


     List<InternshipDto> toInternship(List<Internship> internships);

}


/* public interface InternshipMapper {

        @Mapping(source = "title", target = "title")
        @Mapping(source = "description", target = "description")
        @Mapping(source = "name", target = "name")
        @Mapping(source = "email", target = "email")
        Internship toInternship(InternshipDto internshipDto);
*/




