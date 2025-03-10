package kks.lend36back.controller.user_image.dto;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.persistence.user_image.UserImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link UserImage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserImageDto implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private String userImageData;
}