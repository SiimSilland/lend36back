package kks.lend36back.persistence.student_profile;

import kks.lend36back.controller.student.dto.NameToStudentProfileDto;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentProfileMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(constant = "", target = "address")
    @Mapping(constant = "", target = "phone")
    @Mapping(constant = "", target = "linkedin")
    @Mapping(source = "email", target = "email")
    @Mapping(constant = "", target = "intro")
    StudentProfile toStudentProfile (StudentProfileDto studentProfileDto);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    StudentProfile nameToStudentProfile (NameToStudentProfileDto studentProfileDto);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "linkedin", target = "linkedin")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "intro", target = "intro")
    StudentProfileDto mapToStudentProfileDto (StudentProfile studentProfile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "linkedin", target = "linkedin")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "intro", target = "intro")
    StudentProfile updateStudentProfile(StudentProfileDto studentProfileDto, @MappingTarget StudentProfile studentProfile);

}