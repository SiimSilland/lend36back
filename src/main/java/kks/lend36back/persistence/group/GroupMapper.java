package kks.lend36back.persistence.group;

import kks.lend36back.controller.group.dto.GroupInfo;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

public interface GroupMapper {

    @Mapping(source = "number", target = "number")
    @Mapping(source = "period", target = "period")
    @Mapping(source = "lectorName", target = "lectorName")
    @Mapping(constant = "A", target = "status")
    Group toGroup(NewGroup newGroup);

    @Mapping(source = "id", target = "groupId")
    @Mapping(source = "number", target = "groupNumber")
    @Mapping(source = "period", target = "groupPeriod")
    @Mapping(source = "lectorName", target = "lectorName")
    GroupInfo toGroupInfo(Group group);


    List<GroupInfo> toGroupInfos(List<Group> groups);

}