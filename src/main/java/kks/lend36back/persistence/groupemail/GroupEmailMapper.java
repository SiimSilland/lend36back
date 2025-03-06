package kks.lend36back.persistence.groupemail;

import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface GroupEmailMapper {


    /*
        private Group group;
        private Integer groupNumber;
        private String firstName;
        private String lastName;
        private String email;
        private String status;
    */
    // Ei saa MÄPPIDA @Mapping(source = "", target = "groupId")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    // panen otse GroupEmaili külge   @Mapping(constant = "P", target = "status")
    GroupEmail toGroupEmail(NewGroupEmail newGroupEmail);



    GroupEmail toGroupEmail(NewGroup newGroup);


}