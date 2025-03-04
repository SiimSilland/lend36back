package kks.lend36back.persistence.student_profile;

import kks.lend36back.persistence.group_email.GroupEmail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentProfileMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(constant = "", target = "address")
    @Mapping(constant = "", target = "phone")
    @Mapping(constant = "", target = "linkedin")
    @Mapping(source = "email", target = "email")
    StudentProfile toStudentProfile (GroupEmail groupEmail);


}