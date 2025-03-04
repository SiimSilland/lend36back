package kks.lend36back.persistence.student_profile;

import kks.lend36back.persistence.group_email.GroupEmail;
import kks.lend36back.persistence.user.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentProfileMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    void studentNameFromGroupEmailToStudentProfile(GroupEmail groupEmail);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "id", target = "id")
    User emailToStudentProfile (User user);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(constant = "", target = "address")
    @Mapping(constant = "", target = "phone")
    @Mapping(constant = "", target = "linkedin")
    StudentProfile toStudentProfile (StudentProfile studentProfile);


}