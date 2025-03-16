package kks.lend36back.controller.internship;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.internship.Internship;
import kks.lend36back.persistence.internship.InternshipRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.service.InternshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InternshipController {
    private final InternshipService internshipService;

    @GetMapping("/company/internships")
    public ResponseEntity<List<InternshipDto>> getInternships(@RequestParam Long companyUserId) {
        List<InternshipDto> internships = internshipService.getAllInternships(companyUserId);
        return ResponseEntity.ok(internships);
    }

    @DeleteMapping("/company/internship/{internshipId}")
    @Operation(summary = "Deletes an internship")
    public ResponseEntity<String> deleteInternship(
            @PathVariable Long internshipId,
            @RequestParam Long companyUserId) {

        internshipService.deleteInternship(internshipId, companyUserId);
        return ResponseEntity.ok("Internship deleted successfully");
    }
    @PutMapping("/company/internship/{id}")
    @Operation(summary = "Updates an existing internship")
    public ResponseEntity<String> updateInternship(
            @PathVariable Long id,
            @RequestBody InternshipDto internshipDto) {

        internshipService.updateInternship(id, internshipDto);
        return ResponseEntity.ok("Internship updated successfully");
    }
    @PostMapping("/company/internship")
    @Operation(summary = "Lisab uue praktika koha")
    public void addNewInternship(@RequestBody InternshipDto internshipDto) {
        internshipService.addNewInternship(internshipDto);
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
     @GetMapping("/company/internships")
    @Operation(summary = "Leiab süsteemist praktika kohad")
    public List<InternshipDto> getAllInternships() {
        return internshipService.getAllInternships();
    }

    }
 */