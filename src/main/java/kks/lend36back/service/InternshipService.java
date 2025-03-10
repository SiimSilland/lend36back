package kks.lend36back.service;


import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.internship.Internship;
import kks.lend36back.persistence.internship.InternshipMapper;
import kks.lend36back.persistence.internship.InternshipRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternshipService {

    private final InternshipRepository internshipRepository;
    private final InternshipMapper internshipMapper;
    private final UserRepository userRepository; //

    public void addNewInternship (InternshipDto internshipDto) {
        Integer companyUserId = internshipDto.getCompanyUserId();
        User companyUser = userRepository.findById(companyUserId)
                .orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("companyUserId", companyUserId));
        Internship internship = internshipMapper.toInternship(internshipDto);
        internship.setCompanyUser(companyUser);
        internship.setStatus("A");
        internshipRepository.save(internship);
    }
}

