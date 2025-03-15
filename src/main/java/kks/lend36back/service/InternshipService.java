package kks.lend36back.service;


import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.internship.Internship;
import kks.lend36back.persistence.internship.InternshipMapper;
import kks.lend36back.persistence.internship.InternshipRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipMapper internshipMapper;
    private final UserRepository userRepository;

    @Transactional
    public void addNewInternship(InternshipDto internshipDto) {
        User companyUser = userRepository.findById(internshipDto.getCompanyUserId())
                .orElseThrow(() -> new RuntimeException("Company User not found"));

        Internship internship = internshipMapper.toInternship(internshipDto);
        internship.setCompanyUser(companyUser); // Set the correct user

        internshipRepository.save(internship);
    }

    public List<InternshipDto> getAllInternships() {
        List<Internship> allInternships = internshipRepository.findAll();
        return internshipMapper.toInternship(allInternships);
    }

    @Transactional
    public void deleteInternship(InternshipDto internshipDto) {
        User companyUser = userRepository.findById(internshipDto.getCompanyUserId())
                .orElseThrow(() -> new RuntimeException("Company User not found"));

        Internship internship = internshipRepository.findInternshipBy(companyUser);
        if (internship != null) {
            internshipRepository.delete(internship);
        } else {
            throw new RuntimeException("Internship not found");
        }
    }
}

/*

private Internship createNewInternship(InternshipDto internshipDto, User companyUser) {
            Internship internship = internshipMapper.toInternship(internshipDto);
            internship.setUser(companyUser);
            return internship;
    }
 */