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
import java.util.Optional;
import java.util.stream.Collectors;

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
        internship.setCompanyUser(companyUser); // Assign the correct user
        internshipRepository.save(internship);
    }


    public List<InternshipDto> getAllInternships(Long companyUserId) {
        if (companyUserId == null) {
            throw new IllegalArgumentException("Company User ID cannot be null");
        }
        return internshipRepository.findInternshipsByCompanyUserId(companyUserId);
    }

    @Transactional
    public void deleteInternship(Long internshipId, Long companyUserId) {
        Internship internship = internshipRepository.findById(internshipId)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
        if (internship.getCompanyUser() == null || !internship.getCompanyUser().getId().equals(companyUserId)) {
            throw new RuntimeException("Unauthorized: Cannot delete internship for another company");
        }
        internshipRepository.delete(internship);
    }

    public List<Internship> findByCompanyId(Long companyUserId) {
        return internshipRepository.findByCompanyUser_Id(companyUserId);
    }
}