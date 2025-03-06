package kks.lend36back.service;


import kks.lend36back.controller.admin.dto.NewGroup;
import kks.lend36back.controller.admin.dto.AddStudent;
import kks.lend36back.persistence.group.Group;
import kks.lend36back.persistence.group.GroupMapper;
import kks.lend36back.persistence.group.GroupRepository;
import kks.lend36back.persistence.group_email.GroupEmail;
import kks.lend36back.persistence.group_email.GroupEmailMapper;
import kks.lend36back.persistence.group_email.GroupEmailRepository;
import kks.lend36back.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static kks.lend36back.status.Status.PENDING;


@Service
@RequiredArgsConstructor

public class AdminService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GroupEmailRepository groupEmailRepository;
    private final GroupEmailMapper groupEmailMapper;

    // Todo: transactional
    public void addNewGroup (NewGroup newGroup){
        Group group = groupMapper.toGroup(newGroup);
        GroupEmail newRow = groupEmailMapper.addNewRow(newGroup);

        groupRepository.save(group);

        //GroupEmail groupEmail = groupEmailMapper.toGroupEmail(newGroup);
       // GroupEmail groupEmail = groupEmailMapper.toGroupEmail(user);

    }

    public void addNewStudentToGroup(AddStudent addStudent) {

        GroupEmail studentInfo = groupEmailMapper.toGroupEmail(addStudent);



        Group group = new Group();
        //Integer groupId = group.getId();
       // studentInfo.setGroupId(groupId);

       // addStudent.setGroupId(groupId);
        // Ei saa MÄPPIDA @Mapping(source = "", target = "groupId")

        studentInfo.setStatus(PENDING.getCode());

        // Ei saa MÄPPIDA @Mapping(source = "", target = "status")
        // Ei saa MäPPIDA @Mapping(source = "", target = "groupNumber")


        groupEmailRepository.save(studentInfo);

    }

}
