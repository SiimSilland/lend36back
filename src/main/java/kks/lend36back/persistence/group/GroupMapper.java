package kks.lend36back.persistence.group;

import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})

public interface GroupMapper {

    @Mapping(source = "number", target = "number")
    @Mapping(source = "period", target = "period")
    @Mapping(source = "lectorName", target = "lectorName")
    Group toGroup (NewGroup newGroup);

}