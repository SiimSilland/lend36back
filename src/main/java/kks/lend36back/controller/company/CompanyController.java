package kks.lend36back.controller.company;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.company.dto.CompanyProfileResponseDto;
import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfileDto;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import kks.lend36back.service.CompanyService;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/register")
    @Operation(summary = "lisab uue firma andmebaasi")
    public void addNewCompany(@RequestBody NewCompanyDto newCompany) {
        companyService.addNewCompany(newCompany);
    };

    @GetMapping("/profiles")
    @Operation(
            summary = "Leiab süsteemist (andmebaasist Company profile tabelist nime järgi kõik firmad",
            description = "Tagastab firmad andmetega")

    public List<CompanyProfileResponseDto> getCompanyProfiles(@RequestParam String companyName) {
        List<CompanyProfile> companyProfiles = companyService.getCompanyprofiles(companyName);
        List<CompanyProfileResponseDto> simplifiedProfiles = new ArrayList<>();
        for (CompanyProfile companyProfile : companyProfiles) {
            CompanyProfileResponseDto response = new CompanyProfileResponseDto(
                    companyProfile.getName(),
                    companyProfile.getRegistrationNumber(),
                    companyProfile.getDescription(),
                    companyProfile.getWww(),
                    companyProfile.getAddress(),
                    companyProfile.getPhone()
            );
            simplifiedProfiles.add(response);
        }
        return simplifiedProfiles;
    };

    @PutMapping("/profile")
    @Operation(summary = "Muudetakse firma profiili")
    public void updateCompanyProfile(@RequestBody NewCompanyProfileDto newCompanyProfileDto) {
    companyService.updateCompanyProfile(newCompanyProfileDto);
    };
 }

/*

 @PutMapping("/company/profile")
    @Operation(summary = "Muudetakse firma profiili")
    public CompanyProfileDto updateCompanyProfile(@RequestBody NewCompanyProfile newCompanyProfile) {
               CompanyProfile updatedProfile = companyService.updateCompanyProfile(newCompanyProfile);
               return new CompanyProfileDto(
                updatedProfile.getName(),
                updatedProfile.getRegistrationNumber(),
                updatedProfile.getDescription(),
                updatedProfile.getWww(),
                updatedProfile.getAddress(),
                updatedProfile.getPhone()
        );
*/