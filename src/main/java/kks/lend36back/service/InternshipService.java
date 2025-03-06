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

@Service
@RequiredArgsConstructor
public class InternshipService {

    private final InternshipRepository internshipRepository;
    private final InternshipMapper internshipMapper;
    private final UserRepository userRepository; // Inject UserRepository


    public void addNewInternship (InternshipDto internshipDto) {
        @NotNull User companyUser = userRepository.findById(internshipDto.getCompanyUserId())
                .orElseThrow(() -> new IllegalArgumentException("Company user not found"));Internship internship = internshipMapper.toInternship(internshipDto);
        internship.setCompanyUser(companyUser); // Manually set the company user
        internshipRepository.save(internship);
    }
}





