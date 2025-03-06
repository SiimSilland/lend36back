package kks.lend36back.controller.company;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.company.dto.CompanyProfileDto;
import kks.lend36back.controller.company.dto.CompanyProfileResponseDto;
import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import kks.lend36back.service.CompanyService;
import java.util.List;
import java.util.stream.Collectors;


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
            summary = "Leiab süsteemist (andmebaasist Company profile tabelist nime järgi kõik firmad",
            description = "Tagastab firmad andmetega")
    public List<CompanyProfileResponseDto> getCompanyProfiles(@RequestParam String companyName) {
        List<CompanyProfile> companyProfiles = companyService.getCompanyprofiles(companyName);
        return companyProfiles.stream().map(companyProfile -> {
            CompanyProfileResponseDto response = new CompanyProfileResponseDto();
            response.setName(companyProfile.getName());
            response.setRegistrationNumber(companyProfile.getRegistrationNumber());
            response.setDescription(companyProfile.getDescription());
            response.setWww(companyProfile.getWww());
            response.setAddress(companyProfile.getAddress());
            response.setPhone(companyProfile.getPhone());
            return response;
        }).collect(Collectors.toList());
    }

    /*0public List<CompanyProfile> getCompanyProfiles(@RequestParam String companyName) {
        return companyService.getCompanyprofiles(companyName);
    }*/

    @PutMapping("/company/profile")
    @Operation(summary = "Muudetakse firma profiili")
    public CompanyProfileDto updateCompanyProfile(@RequestBody NewCompanyProfile newCompanyProfile) {
        // Assuming the company service updates the company profile and returns the updated CompanyProfile object
        CompanyProfile updatedProfile = companyService.updateCompanyProfile(newCompanyProfile);

        // Map the updated profile to the simplified response DTO
        return new CompanyProfileDto(
                updatedProfile.getName(),
                updatedProfile.getRegistrationNumber(),
                updatedProfile.getDescription(),
                updatedProfile.getWww(),
                updatedProfile.getAddress(),
                updatedProfile.getPhone()
        );
    }
}

   /* public void updateCompanyProfile(@RequestBody NewCompanyProfile newCompanyProfile) {
        companyService.updateCompanyProfile(newCompanyProfile);
 */




