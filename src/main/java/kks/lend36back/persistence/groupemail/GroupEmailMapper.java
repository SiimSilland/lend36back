package kks.lend36back.persistence.groupemail;

import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group_email.dto.GroupEmailInfo;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface GroupEmailMapper {


    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    // panen otse GroupEmaili külge   @Mapping(constant = "P", target = "status")
    GroupEmail toGroupEmail(NewGroupEmail newGroupEmail);

    GroupEmail toGroupEmail(NewGroup newGroup);

    @Mapping(source = "group.number", target = "groupNumber")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "status", target = "status")
    GroupEmailInfo toGroupEmailInfo(GroupEmail groupEmail);


   List <GroupEmailInfo> toGroupEmailInfos(List <GroupEmail> groupEmails);




}