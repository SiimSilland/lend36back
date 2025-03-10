package kks.lend36back.controller.student.dto;

import kks.lend36back.persistence.student_profile.StudentProfile;
import kks.lend36back.persistence.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; /**
 * DTO for {@link StudentProfile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentProfileRequest {
    private StudentProfileDto studentProfileDto;
    private User user;
}
