package kks.lend36back.controller.cv.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link kks.lend36back.persistence.cv.Cv}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private String cvData;
}