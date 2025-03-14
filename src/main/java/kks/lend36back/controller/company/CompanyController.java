package kks.lend36back.controller.company;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.CompanyDto;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/company/register")
    @Operation(summary = "lisab uue firma andmebaasi")
    public void addNewCompany(@RequestBody @Valid NewCompany newCompany) {
        companyService.addNewCompany(newCompany);
    }

    @PutMapping("/company/profile/update")
    @Operation(summary = "Muudetakse firma profiili")
    public void updateCompanyProfile(@RequestParam Integer userId, @RequestBody @Valid CompanyDto companyDto) {
        companyService.updateCompanyProfile(userId, companyDto);
    }

    @GetMapping("/company/profile")
    @Operation(summary = "Returns company profile by userId")
    public CompanyDto getCompanyProfile(@RequestParam Integer userId) {
        CompanyDto companyProfileByUserId = companyService.getCompanyProfileByUserId(userId);
        return companyProfileByUserId;
    }

    @GetMapping("/company/profile/all")
    @Operation(summary = "Leiab süsteemist Company profilili andmed")
    public List<NewCompany> getAllCompanyProfiles() {
        return companyService.getAllCompanyProfiles();

    }
    @DeleteMapping("/company/profile/delete")
    @Operation(summary = "kustutab kompanii profiili")
    public void deleteCompanyProfile (@RequestParam Integer userId) {
        companyService.deleteCompanyProfile (userId);
    }
}
