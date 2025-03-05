package kks.lend36back.persistence.group_email;

import kks.lend36back.controller.admin.dto.NewGroupEmail;
import kks.lend36back.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface GroupEmailMapper {
//@Mapping(source = "group", target = "group")
@Mapping(source = "firstName", target = "firstName")
@Mapping(source = "lastName", target = "lastName")
@Mapping(source = "email", target = "email")
@Mapping(source = "status", target = "status")
    GroupEmail toGroupEmail (NewGroupEmail newGroupEmail);
}