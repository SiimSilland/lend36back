package kks.lend36back.persistence.user;

import kks.lend36back.controller.login.dto.LoginResponse;
import kks.lend36back.controller.student.dto.NewCompany;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.status.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse (User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "status", target = "status")
    User newStudentToUser (NewStudent newStudent);
/*
    @Mapping(source = "", target = "email")
    @Mapping(source = "", target = "password")
    @Mapping(source = "", target = "id")
    @Mapping(source = "", target = "role")
    @Mapping(source = "", target = "status")
    User newCompany (NewCompany newCompany);
*/

}