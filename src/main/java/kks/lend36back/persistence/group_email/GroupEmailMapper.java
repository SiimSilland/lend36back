package kks.lend36back.persistence.group_email;

import kks.lend36back.controller.admin.dto.AddStudent;
import kks.lend36back.controller.admin.dto.NewGroup;
import kks.lend36back.persistence.group.Group;
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
    // Ei saa MäPPIDA @Mapping(source = "", target = "groupNumber")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    // Ei saa MÄPPIDA @Mapping(source = "", target = "status")
    GroupEmail toGroupEmail (AddStudent addStudent);

//    @Mapping(source = "" , target = "groupId")
    @Mapping(source = "number" , target = "groupNumber")
    GroupEmail addNewRow (NewGroup newGroup);



}