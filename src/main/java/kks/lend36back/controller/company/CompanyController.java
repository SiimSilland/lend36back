package kks.lend36back.controller.company;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import kks.lend36back.service.CompanyService;
import java.util.List;


@RestController
@RequiredArgsConstructor

public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/company/register")
    @Operation(summary = "lisab uue firma andmebaasi")
    public void addNewCompany(@RequestBody NewCompanyDto newCompany) {
        companyService.addNewCompany(newCompany);
    }

    @GetMapping("/company/profiles")
    @Operation(
            summary = "Leiab süsteemist (andmebaasist Company profile tabelist) kõik firmad",
            description = "Tagastab firmad andmetega")
    public List<CompanyProfile> getCompanyProfiles(@RequestParam String companyName) {
        return companyService.getCompanyprofiles(companyName);
    }

    @PutMapping("/company/profile")
    @Operation(summary = "Muudetakse firma profiili")
    public void updateCompanyProfile(@RequestBody NewCompanyProfile newCompanyProfile) {
        companyService.updateCompanyProfile(newCompanyProfile);
    }

}



