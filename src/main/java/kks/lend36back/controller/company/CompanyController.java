package kks.lend36back.controller.company;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.company.dto.NewCompanyProfile;
import kks.lend36back.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/company/register")
    @Operation (summary = "lisab uue firma andmebaasi")
    public void addNewCompany(@RequestBody NewCompany newCompany) {
        companyService.addNewCompany(newCompany);
    }

    @GetMapping("/company/profile")
    @Operation(
            summary = "Leiab süsteemist (andmebaasist Company profile tabelist) kõik firmad",
            description = "Tagastab firmad andmetega")
    public List<NewCompanyProfile> getCompanyProfile() {
        return companyService.getCompanyProfile();
    }

    @PostMapping("/company/profile")
    @Operation(summary = "Muudetakse firma profiili")
    public void updateCompanyProfile(@RequestBody NewCompanyProfile newCompanyProfile){
        companyService.updateCompanyProfile(newCompanyProfile);
    }
}

/*
    public List<NewCompanyProfile> getCompanyProfile() {
        List<CompanyProfile> AllCompanyProfiles = companyProfileRepository.findAll();
        List<NewCompanyProfile> companyProfiles = companyProfileMapper.toCompanyProfiles(AllCompanyProfiles);
        return companyProfiles;



        public void addNewStudent(@RequestBody @Valid NewStudent newStudent){

        studentService.addNewStudent(newStudent);
    }

        }
*/