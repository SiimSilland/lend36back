package kks.lend36back.controller.company;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.CompanyDto;
import kks.lend36back.controller.company.dto.NewCompany;
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

    @GetMapping("/company/profile/all")
    @Operation(summary = "Leiab süsteemist Company profilili andmed")
    public List<NewCompany> getAllCompanyProfiles() {
        return companyService.getAllCompanyProfiles();

    }

}
/*@GetMapping("/company/profile")
@Operation(
        summary = "Leiab süsteemist Company profilili andmed userId järgi")
public void getCompanyProfile(@RequestParam Integer userId) {
    companyService.getCompanyProfile(userId);   //todo: vaja teha
} @PostMapping("/company/profile/create")
    @Operation (summary = "loob uue firma profiili")
    public void createCompanyProfile(@RequestBody NewCompanyProfileDto newCompanyProfileDto, @RequestParam Integer userId) {
        companyService.saveCompanyProfile (newCompanyProfileDto, userId);
    }
*/
