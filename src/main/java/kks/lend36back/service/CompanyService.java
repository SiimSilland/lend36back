package kks.lend36back.service;

import kks.lend36back.controller.student.dto.NewCompany;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CompanyService {

    public static final int ROLE_COMPANY = 3;

    private static RoleRepository roleRepository;
    private final UserMapper userMapper;

    public void addNewCompany(NewCompany newCompany) {
        Role role = roleRepository.getReferenceById(ROLE_COMPANY);
    }
    }
