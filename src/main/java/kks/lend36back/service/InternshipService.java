package kks.lend36back.service;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.persistence.internship.Internship;
import kks.lend36back.persistence.internship.InternshipMapper;
import kks.lend36back.persistence.internship.InternshipRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternshipService {

    private final InternshipRepository internshipRepository;
    private final InternshipMapper internshipMapper;
    private final UserRepository userRepository; //

    @Transactional
    public void addNewInternship (User user, InternshipDto internshipDto) {
        Internship internship = createNewInternship(internshipDto, user);
        internshipRepository.save(internship);
        }
    private Internship createNewInternship(InternshipDto internshipDto, User user) {
            Internship internship = internshipMapper.toInternship(internshipDto);
            internship.setUser(user);
            return internship;
    }
    public List<InternshipDto> getAllInternships() {
        List<Internship> internships = internshipRepository.findAll();
        return internshipMapper.toInternship(internships);

    }
}

