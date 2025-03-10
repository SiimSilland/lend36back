package kks.lend36back.persistence.user;

import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.login.dto.LoginResponse;
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
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User toUser(NewStudent newStudent);

    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    User toUser(NewCompany newCompany);

}