package kks.lend36back.service;


import kks.lend36back.controller.admin.dto.NewGroup;
import kks.lend36back.controller.admin.dto.NewGroupEmail;
import kks.lend36back.persistence.group.Group;
import kks.lend36back.persistence.group.GroupMapper;
import kks.lend36back.persistence.group.GroupRepository;
import kks.lend36back.persistence.group_email.GroupEmail;
import kks.lend36back.persistence.group_email.GroupEmailMapper;
import kks.lend36back.persistence.group_email.GroupEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AdminService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GroupEmailRepository groupEmailRepository;
    private final GroupEmailMapper groupEmailMapper;

    public void addNewGroup (NewGroup newGroup){
        Group group = groupMapper.toGroup(newGroup);
        Group savedGroup = groupRepository.save(group);
        System.out.println(savedGroup);

    }

    public void addNewGroupEmail (NewGroupEmail newGroupEmail) {
        GroupEmail groupEmail = groupEmailMapper.toGroupEmail (newGroupEmail);
        groupEmailRepository.save(groupEmail);

    }

}
