package kks.lend36back.controller.student_preference;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.service.StudentPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student-preference")
public class StudentPreferenceController {
    private final StudentPreferenceService studentPreferenceService;
    @PostMapping("/date")
    @Operation (summary = "õppuri praktikaperioodi eelistuse lisamine")
    public void addStudentPreference(@RequestParam Integer userId, @RequestParam Integer fromDate) {
    studentPreferenceService.addStudentPreference(userId, fromDate);
    }

    @PostMapping("/update")
    @Operation (summary = "õppuri praktrikaperioodi eelistuse uuendamine")
    public void updateStudentPreference(@RequestParam Integer userId, @RequestParam Integer fromDate) {
        studentPreferenceService.updateStudentPreference(userId, fromDate);
    }
}
