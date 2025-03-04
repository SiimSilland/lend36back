package kks.lend36back.persistence.student_profile;

import kks.lend36back.persistence.group_email.GroupEmail;
import kks.lend36back.persistence.user.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentProfileMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    GroupEmail studentNameToStudentProfile (GroupEmail groupEmail);

    @Mapping(source = "email", target = "email")
    User emailToStudentProfile (User user);

}