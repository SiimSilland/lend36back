package kks.lend36back.persistence.internship;

import kks.lend36back.controller.internship.dto.InternshipDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InternshipMapper {


    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "coordinatorName", target = "coordinatorName")
    @Mapping(source = "coordinatorEmail", target = "coordinatorEmail")


    Internship toInternship(InternshipDto internship);


}