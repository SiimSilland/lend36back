package kks.lend36back.controller.student_preference.dto;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.persistence.student_preference.StudentPreference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link StudentPreference}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPreferenceDto implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer fromDate;
}