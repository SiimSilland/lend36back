package kks.lend36back.controller.student;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.persistence.student_profile.StudentProfile;
import kks.lend36back.persistence.student_profile.StudentProfileRepository;
import kks.lend36back.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/user")
    @Operation(summary = "Uue õppuri lisamine. Kontrollib õppuri emaili admini andmebaasist")
    public void addNewStudent(@RequestBody @Valid NewStudent newStudent) {
        studentService.addNewStudent(newStudent);
    }


    @GetMapping("/student/profile")
    @Operation(summary = "Returns student profile by userId")
    public StudentProfileDto getStudentProfile(@RequestParam Integer userId) {
        StudentProfileDto studentProfileByUserId = studentService.getStudentProfileByUserId(userId);
        return studentProfileByUserId;
    }


    @PutMapping("/student/profile")
    @Operation(summary = "Uue õppuri muutmine")
    public void updateStudentProfile(@RequestParam Integer userId, @RequestBody @Valid StudentProfileDto studentProfileDto) {
        studentService.updateStudentProfile(userId, studentProfileDto);
    }

    @Autowired
    private StudentProfileRepository studentProfileRepository;
        @GetMapping("/student/profile")
        public List<StudentProfile> getAllStudentProfiles() {
            return studentProfileRepository.findAll();
        }
    }

