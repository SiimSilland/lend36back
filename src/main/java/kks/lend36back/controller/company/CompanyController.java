package kks.lend36back.controller.company;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CompanyController {
    private final CompanyService companyService;

       @PostMapping("/company/register")
   @Operation (summary = "lisab uue firma andmebaasi")

       public void addNewCompany(@RequestBody NewCompany newCompany) {
        companyService.addNewCompany(newCompany);
    }
}

/*
    public void addNewStudent(@RequestBody @Valid NewStudent newStudent){

        studentService.addNewStudent(newStudent);
    }

        }
*/