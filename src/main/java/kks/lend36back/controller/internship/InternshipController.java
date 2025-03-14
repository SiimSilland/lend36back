package kks.lend36back.controller.internship;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.internship.InternshipRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.service.InternshipService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class InternshipController {
    private final InternshipService internshipService;
    private final InternshipRepository internshipRepository;
    private final UserRepository userRepository;

    @GetMapping("/company/intrenship/all")
    @Operation(summary = "Leiab süsteemist praktika kohad")
    public List<InternshipDto> getAllInternships() {
        return (List<InternshipDto>) internshipService.getAllInternships();
    }

    @DeleteMapping("/company/internship/delete")
    @Operation(summary = "kustutab praktika sisendi")
    public void deleteInternship (@RequestParam User comnpanyUser) {
        internshipService.deleteInternship(comnpanyUser);
    }

    @PostMapping("/company/internship")
    @Operation(summary = "Lisab uue praktika koha")
    public void addNewInternship(@RequestBody InternshipDto internshipDto, @RequestParam ("userid") Integer userId) {
       User companyUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        internshipService.addNewInternship(companyUser, internshipDto);
    }
}
/*
@PostMapping("/company/internship")
    public void addNewInternship(@RequestBody InternshipDto internshipDto, @RequestParam Long userId) {
        User companyUser = internshipRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        internshipService.updateInternship(companyUser, internshipDto);
    }@PostMapping("/company/internship")
    @Operation(summary = "lisab uue praktikakoha ja uuendab juhendaja andmeid/")
    public void addNewInternship (@RequestBody InternshipDto internshipDto, @RequestParam User companyUser) {
        internshipService.addNewInternship(companyUser, internshipDto);
    }
 */