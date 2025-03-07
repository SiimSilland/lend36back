package kks.lend36back.controller.student.dto;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.persistence.cv.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Cv}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCv implements Serializable {
    @NotNull
    private byte[] data;
    @NotNull
    private Integer user;

}