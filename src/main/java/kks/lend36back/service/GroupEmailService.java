package kks.lend36back.service;

import kks.lend36back.controller.group_email.dto.GroupEmailInfo;
import kks.lend36back.persistence.groupemail.GroupEmail;
import kks.lend36back.persistence.groupemail.GroupEmailMapper;
import kks.lend36back.persistence.groupemail.GroupEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class GroupEmailService {
    private final GroupEmailMapper groupEmailMapper;
    private final GroupEmailRepository groupEmailRepository;


    public List<GroupEmailInfo> getGroupEmails(Integer groupId) {
        List<GroupEmail> groupEmails = groupEmailRepository.findGroupEmailsBy(groupId);
        List<GroupEmailInfo> groupEmailInfos = groupEmailMapper.toGroupEmailInfos(groupEmails);
        return groupEmailInfos;
    }
}

