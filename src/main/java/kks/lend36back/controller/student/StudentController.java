package kks.lend36back.controller.student;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.persistence.user.User;
import kks.lend36back.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student/register")
    @Operation(summary = "Uue õppuri lisamine. Kontrollib õppuri emaili admini andmebaasist")

    public void addNewStudent(@RequestBody @Valid NewStudent newStudent) {
        studentService.addNewStudent(newStudent);
    }
@PostMapping("/student/profile")
    @Operation(summary = "uue profiili lisamine")
    public void createAndSaveStudentProfile(@RequestBody @Valid StudentProfileDto studentProfileDto, User user) {
        studentService.createAndSaveStudentProfile(studentProfileDto, user);
    }
}


