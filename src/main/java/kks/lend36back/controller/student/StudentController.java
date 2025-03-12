package kks.lend36back.controller.student;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.controller.student.dto.StudentProfileRequest;
import kks.lend36back.persistence.user.User;
import kks.lend36back.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class StudentController {
    private final StudentService studentService;

    @PostMapping("/user")
    @Operation(summary = "Uue õppuri lisamine. Kontrollib õppuri emaili admini andmebaasist")

    public void addNewStudent(@RequestBody @Valid NewStudent newStudent) {
        studentService.addNewStudent(newStudent);
    }

    @PostMapping("/student/profile/create")
    @Operation(summary = "uue profiili lisamine")
    public void createAndSaveStudentProfile(@RequestBody @Valid StudentProfileRequest request, @RequestParam Integer userId) {
        studentService.createAndSaveStudentProfile(request.getStudentProfileDto(), userId);
    }

    @GetMapping("/student/profile/get")
    @Operation(summary = "Returns student profile by userId")
    public StudentProfileDto getStudentProfile(@RequestParam Integer userId){
        StudentProfileDto studentProfileByUserId = studentService.getStudentProfileByUserId(userId);
        return studentProfileByUserId;

    }



}
