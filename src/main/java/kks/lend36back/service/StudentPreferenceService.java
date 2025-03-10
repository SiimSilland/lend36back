package kks.lend36back.service;

import kks.lend36back.persistence.student_preference.StudentPreference;
import kks.lend36back.persistence.student_preference.StudentPreferenceRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentPreferenceService {
    private final UserRepository userRepository;
    private final StudentPreferenceRepository studentPreferenceRepository;

    public void addStudentPreference(Integer userId, Integer fromDate) {
        User userById = userRepository.findUserById(userId);
        StudentPreference studentPreference = new StudentPreference();
        studentPreference.setUser(userById);
        studentPreference.setFromDate(fromDate);
        studentPreferenceRepository.save(studentPreference);
    }

    public void updateStudentPreference(Integer userId, Integer fromDate) {
        User userById = userRepository.findUserById(userId);
        StudentPreference studentPreference = new StudentPreference();
        studentPreference.setUser(userById);
        studentPreference.setFromDate(fromDate);
        studentPreferenceRepository.save(studentPreference);
    }
}
