package kks.lend36back.controller.company;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfileDto;
import kks.lend36back.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/company/register")
    @Operation(summary = "lisab uue firma andmebaasi")
    public void addNewCompany(@RequestBody NewCompanyDto newCompany) {
        companyService.addNewCompany(newCompany);
    }

    @GetMapping("/company/profile")
    @Operation(
            summary = "Leiab süsteemist Company profilili andmed userId järgi")
    public void getCompanyProfile(@RequestParam Integer userId) {
        companyService.getCompanyProfile(userId);   //todo: vaja teha
    }

    @PutMapping("/company/profile")
    @Operation(summary = "Muudetakse firma profiili")
    public void updateCompanyProfile(@RequestParam Integer userId, @RequestBody @Valid NewCompanyProfileDto newCompanyProfileDto) {
        companyService.updateCompanyProfile(userId, newCompanyProfileDto);
    }
}
