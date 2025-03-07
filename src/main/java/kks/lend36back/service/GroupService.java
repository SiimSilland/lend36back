package kks.lend36back.service;


import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.persistence.group.Group;
import kks.lend36back.persistence.group.GroupMapper;
import kks.lend36back.persistence.group.GroupRepository;
import kks.lend36back.persistence.groupemail.GroupEmail;
import kks.lend36back.persistence.groupemail.GroupEmailMapper;
import kks.lend36back.persistence.groupemail.GroupEmailRepository;
import kks.lend36back.status.Status;
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

        groupRepository.save(group);

    }

    public void addGroupEmail(NewGroupEmail newGroupEmail) {
        Integer groupId = newGroupEmail.getGroupId();

        Group group = groupRepository.findById(groupId).orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("groupId", groupId));
        GroupEmail groupEmail = groupEmailMapper.toGroupEmail(newGroupEmail);
        groupEmail.setGroup(group);
        groupEmail.setStatus(PENDING.getCode());
        groupEmailRepository.save(groupEmail);

    }

}
