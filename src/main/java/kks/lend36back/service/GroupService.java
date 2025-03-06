package kks.lend36back.service;


import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.persistence.group.Group;
import kks.lend36back.persistence.group.GroupMapper;
import kks.lend36back.persistence.group.GroupRepository;
import kks.lend36back.persistence.groupemail.GroupEmail;
import kks.lend36back.persistence.groupemail.GroupEmailMapper;
import kks.lend36back.persistence.groupemail.GroupEmailRepository;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static kks.lend36back.status.Status.PENDING;


@Service
@RequiredArgsConstructor

public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GroupEmailRepository groupEmailRepository;
    private final GroupEmailMapper groupEmailMapper;

    // Todo: transactional
    public void addNewGroup (NewGroup newGroup){
        Group group = groupMapper.toGroup(newGroup);
        GroupEmail newRow = groupEmailMapper.toGroupEmail(newGroup);

        groupRepository.save(group);

        //GroupEmail groupEmail = groupEmailMapper.toGroupEmail(newGroup);
       // GroupEmail groupEmail = groupEmailMapper.toGroupEmail(user);

    }

    public void addGroupEmail(NewGroupEmail newGroupEmail) {
        Integer groupId = newGroupEmail.getGroupId();

        // Ei saa MÄPPIDA FOREIGN KEYD @Mapping(source = "", target = "groupId")
        Group group = groupRepository.findById(groupId).orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("groupId", groupId));


        // @Mapping(constant = "EI SAA MÄPPIDA", target = "groupNumber")



        GroupEmail groupEmail = groupEmailMapper.toGroupEmail(newGroupEmail);
        groupEmail.setGroup(group);
        groupEmail.setGroupNumber();



        groupEmail.setStatus(PENDING.getCode());

        // Ei saa MÄPPIDA @Mapping(source = "", target = "status")
        // Ei saa MäPPIDA @Mapping(source = "", target = "groupNumber")


        groupEmailRepository.save(groupEmail);

    }

}
